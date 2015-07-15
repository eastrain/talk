/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package easemob.liaoliao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.easemob.chat.EMMessage;

import easemob.liaoliao.R;

public class ContextMenuActivity extends BaseActivity {

	private TextView copyTextView;
	private View copyLineView;
	private TextView deleteTextView;
	private View deleteLineView;
	private TextView forwardTextView;
	private View forwardLineView;

	private int position;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_context_menu;
	}

	@Override
	public void initViewId() {
		copyTextView = (TextView)findViewById(R.id.tv_copy);
		copyLineView =(View)findViewById(R.id.copy_line);
		deleteTextView =(TextView)findViewById(R.id.tv_delete);
		deleteLineView = (View)findViewById(R.id.delete_line);
		forwardTextView =(TextView)findViewById(R.id.tv_forward);
		forwardLineView = (View)findViewById(R.id.forward_line);

	}

	@Override
	public void setUpView() {

		int txtValue = EMMessage.Type.TXT.ordinal();
		int type = getIntent().getIntExtra("type", -1);
		if (type == EMMessage.Type.TXT.ordinal()) {

		} else if (type == EMMessage.Type.LOCATION.ordinal()) {
			copyTextView.setVisibility(View.GONE);
			copyLineView.setVisibility(View.GONE);
			forwardTextView.setVisibility(View.GONE);
			forwardLineView.setVisibility(View.GONE);
		} else if (type == EMMessage.Type.IMAGE.ordinal()) {
			copyTextView.setVisibility(View.GONE);
			copyLineView.setVisibility(View.GONE);

		} else if (type == EMMessage.Type.VOICE.ordinal()) {
			copyTextView.setVisibility(View.GONE);
			copyLineView.setVisibility(View.GONE);
			forwardTextView.setVisibility(View.GONE);
			forwardLineView.setVisibility(View.GONE);

			deleteTextView.setText(getResources().getString(R.string.delete_voice));

		} else if (type == EMMessage.Type.VIDEO.ordinal()) {
			copyTextView.setVisibility(View.GONE);
			copyLineView.setVisibility(View.GONE);
			forwardTextView.setVisibility(View.GONE);
			forwardLineView.setVisibility(View.GONE);

			deleteTextView.setText(getResources().getString(R.string.delete_video));
		}

		position = getIntent().getIntExtra("position", -1);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

	public void copy(View view){
		setResult(ChatActivity.RESULT_CODE_COPY, new Intent().putExtra("position", position));
		finish();
	}
	public void delete(View view){
		setResult(ChatActivity.RESULT_CODE_DELETE, new Intent().putExtra("position", position));
		finish();
	}
	public void forward(View view){
		setResult(ChatActivity.RESULT_CODE_FORWARD, new Intent().putExtra("position", position));
		finish();
	}
	
	public void open(View v){
	    setResult(ChatActivity.RESULT_CODE_OPEN, new Intent().putExtra("position", position));
        finish();
	}
	public void download(View v){
	    setResult(ChatActivity.RESULT_CODE_DWONLOAD, new Intent().putExtra("position", position));
        finish();
	}
	public void toCloud(View v){
	    setResult(ChatActivity.RESULT_CODE_TO_CLOUD, new Intent().putExtra("position", position));
        finish();
	}

	@Override
	public void onClick(View v) {

	}
}
