package com.example.conclusion.PhoneAndSms;

import java.util.ArrayList;

import com.example.conclusion.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_PhoneAndSms extends Activity implements OnClickListener {

	EditText et_PhoneAndSms_phoneText, et_PhoneAndSms_SmsPhone, et_PhoneAndSms_SmsText;
	Button btn_PhoneAndSms_callPhone1, btn_PhoneAndSms_callPhone2, btn_PhoneAndSms_sendSms,
			btn_PhoneAndSms_sendSmsForSystem;
	boolean flg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phoneandsms);

		et_PhoneAndSms_phoneText = (EditText) findViewById(R.id.et_PhoneAndSms_phoneText);
		et_PhoneAndSms_SmsPhone = (EditText) findViewById(R.id.et_PhoneAndSms_SmsPhone);
		et_PhoneAndSms_SmsText = (EditText) findViewById(R.id.et_PhoneAndSms_SmsText);

		btn_PhoneAndSms_callPhone1 = (Button) findViewById(R.id.btn_PhoneAndSms_callPhone1);
		btn_PhoneAndSms_callPhone2 = (Button) findViewById(R.id.btn_PhoneAndSms_callPhone2);
		btn_PhoneAndSms_sendSms = (Button) findViewById(R.id.btn_PhoneAndSms_sendSms);
		btn_PhoneAndSms_sendSmsForSystem = (Button) findViewById(R.id.btn_PhoneAndSms_sendSmsForSystem);

		btn_PhoneAndSms_callPhone1.setOnClickListener(this);
		btn_PhoneAndSms_callPhone2.setOnClickListener(this);
		btn_PhoneAndSms_sendSms.setOnClickListener(this);
		btn_PhoneAndSms_sendSmsForSystem.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_PhoneAndSms_callPhone1:
			flg = true;
			CallPhone();
			break;
		case R.id.btn_PhoneAndSms_callPhone2:
			flg = false;
			CallPhone();
			break;
		case R.id.btn_PhoneAndSms_sendSms:
			SendSms();
			break;
		case R.id.btn_PhoneAndSms_sendSmsForSystem:
			SendSmsForSystem();
			break;
		}

	}

	// ����绰
	private void CallPhone() {
		String PhoneNumber = et_PhoneAndSms_phoneText.getText().toString();
		if (!"".equals(PhoneNumber)) {

			// Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
			// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			// startActivity(intent);

			Intent intent = new Intent();
			if (flg) {
				// ֱ�Ӳ���绰
				intent.setAction(Intent.ACTION_CALL);
			} else {
				// ��ת�����Ž���
				intent.setAction(Intent.ACTION_DIAL);
			}
			intent.setData(Uri.parse("tel:" + PhoneNumber));
			startActivity(intent);

		} else
			Toast.makeText(this, "������绰���룡", Toast.LENGTH_SHORT).show();
	}

	// ֱ�ӷ��Ͷ���
	private void SendSms() {

		String PhoneNumber = et_PhoneAndSms_SmsPhone.getText().toString();
		String SmsText = et_PhoneAndSms_SmsText.getText().toString();

		if (!"".equals(PhoneNumber) && !"".equals(SmsText)) {

			SmsManager smsManager = SmsManager.getDefault();
			// ��ȡ SmsManager��Ĭ��ʵ��
			// smsManager.sendTextMessage(PhoneNumber, null, SmsText, null, null);

			// ��һ����Ϣ�ı��ֳɼ���Ƭ�Σ�����ܴ��ڶ��Ŵ�С
			ArrayList<String> list = smsManager.divideMessage(SmsText);
			Log.i("SmsSize", "-->" + list.size());
			for (int i = 0; i < list.size(); i++) {
				smsManager.sendTextMessage(PhoneNumber, null, list.get(i).toString(), null, null);
				Log.i("SMS", "-->" + list.get(i).toString());
			}

			Toast.makeText(this, "���ͳɹ���", Toast.LENGTH_SHORT).show();
		} else
			Toast.makeText(this, "�������ռ��˺������Ϣ���ݣ�", Toast.LENGTH_SHORT).show();

	}

	// ����ϵͳ������Ϣ����
	private void SendSmsForSystem() {
		String PhoneNumber = et_PhoneAndSms_SmsPhone.getText().toString();
		String SmsText = et_PhoneAndSms_SmsText.getText().toString();

		if (!"".equals(PhoneNumber)) {

			Uri smsToUri = Uri.parse("smsto:" + PhoneNumber);
			Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
			intent.putExtra("sms_body", SmsText);
			startActivity(intent);

			// Intent intent=new Intent(Intent.ACTION_VIEW);
			// intent.setData(Uri.parse("smsto:"));
			// intent.setType("vnd.android-dir/mms-sms");
			// intent.putExtra("address",PhoneNumber);
			// intent.putExtra("sms_body", SmsText);
			// startActivity(intent);

		} else
			Toast.makeText(this, "�������ռ��˺������Ϣ���ݣ�", Toast.LENGTH_SHORT).show();
	}
}
