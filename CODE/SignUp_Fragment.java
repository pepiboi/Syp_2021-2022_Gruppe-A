package com.login_signup_screendesign_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp_Fragment extends Fragment implements OnClickListener {
	private static View view;
	private static EditText fullName, emailId, mobileNumber, birthdate,
			password, confirmPassword;
	private static TextView login;
	private static Button signUpButton;
	private static CheckBox terms_conditions;
	private UserSignups userSignups;

	public SignUp_Fragment() {
		userSignups = new UserSignups();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.signup_layout, container, false);
		initViews();
		setListeners();
		return view;
	}

	// Initialize all views
	private void initViews() {
		fullName = (EditText) view.findViewById(R.id.fullName);
		emailId = (EditText) view.findViewById(R.id.userEmailId);
		mobileNumber = (EditText) view.findViewById(R.id.mobileNumber);
		birthdate = (EditText) view.findViewById(R.id.birthdate);
		password = (EditText) view.findViewById(R.id.password);
		confirmPassword = (EditText) view.findViewById(R.id.confirmPassword);
		signUpButton = (Button) view.findViewById(R.id.signUpBtn);
		login = (TextView) view.findViewById(R.id.already_user);
		terms_conditions = (CheckBox) view.findViewById(R.id.terms_conditions);

		// Setting text selector over textviews
		@SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
		try {
			ColorStateList csl = ColorStateList.createFromXml(getResources(),
					xrp);

			login.setTextColor(csl);
			terms_conditions.setTextColor(csl);
		} catch (Exception e) {
		}
	}

	// Set Listeners
	private void setListeners() {
		signUpButton.setOnClickListener(this);
		login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.signUpBtn:

			// Call checkValidation method
			checkValidation(v.getContext());
			break;

		case R.id.already_user:

			// Replace login fragment
			new MainActivity().replaceLoginFragment();
			break;
		}

	}

	// Check Validation Method
	private void checkValidation(Context context) {
		Date d = new Date();
		// Get all edittext texts
		String getFullName = fullName.getText().toString();
		String getEmailId = emailId.getText().toString();
		String getMobileNumber = mobileNumber.getText().toString();
		String getBirthdate = birthdate.getText().toString();
		String getPassword = password.getText().toString();
		String getConfirmPassword = confirmPassword.getText().toString();

		// Pattern match for email id
		Pattern pDate = Pattern.compile(Utils.regExDate);
		Matcher mDate = pDate.matcher(getBirthdate);
		Pattern pMail = Pattern.compile(Utils.regEx);
		Matcher mMail = pMail.matcher(getEmailId);

		// Check if all strings are null or not
		if (getFullName.equals("") || getFullName.length() == 0
				|| getEmailId.equals("") || getEmailId.length() == 0
				|| getMobileNumber.equals("") || getMobileNumber.length() == 0
				|| getBirthdate.equals("") || getBirthdate.length() == 0
				|| getPassword.equals("") || getPassword.length() == 0
				|| getConfirmPassword.equals("")
				|| getConfirmPassword.length() == 0) {

			new CustomToast().Show_Toast(getActivity(), view,
					"All fields are required.");
		}else if (!mDate.find()) {
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Birthdate is Invalid.");
		}else {
			String[] strings = getBirthdate.split("/");
			int[] dateObjects = {Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2])};
			d.setDate(dateObjects[0]);
			d.setMonth(dateObjects[1]);
			d.setYear(dateObjects[2]);
			Date d1 = new Date();
			d1.setMonth(d1.getMonth()+1);
			d1.setYear(2006);
			if(d1.before(d)){
				new CustomToast().Show_Toast(getActivity(), view,
						"Get older!");
				return;
			}
		}
		// Check if email id valid or not
		if (!mMail.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");

		else if(UserSignups.emailExists(getEmailId))
			new CustomToast().Show_Toast(getActivity(), view,
					"This Email Id is already taken!.");
		// Check if both password should be equal
		else if (!getConfirmPassword.equals(getPassword))
			new CustomToast().Show_Toast(getActivity(), view,
					"Both password doesn't match.");

		// Make sure user should check Terms and Conditions checkbox
		else if (!terms_conditions.isChecked())
			new CustomToast().Show_Toast(getActivity(), view,
					"Please select Terms and Conditions.");

		// Else do signup or do your stuff
		else
			Toast.makeText(getActivity(), "Do SignUp.", Toast.LENGTH_SHORT)
					.show();
		userSignups.addUser(new UserData(getFullName, getEmailId, getMobileNumber, d, getPassword, false));
		System.out.println(userSignups.getUserSignupsList().size());
		try {
			FileOutputStream fos = context.openFileOutput("SignUps.csv", Context.MODE_PRIVATE);
			PrintWriter out = new PrintWriter(new OutputStreamWriter(fos));
			out.println (userSignups.getUserSignupsList().get(0)) ;
			out.flush() ;
			out.close() ;
		} catch (FileNotFoundException exp) {
			exp.printStackTrace();
		}
	}
}
