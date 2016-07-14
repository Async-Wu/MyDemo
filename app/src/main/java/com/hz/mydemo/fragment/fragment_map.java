package com.hz.mydemo.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hz.mydemo.AminationActivity;
import com.hz.mydemo.MapActivity;
import com.hz.mydemo.R;
import com.hz.mydemo.base.BaseFragment;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * Created by Administrator on 2016/6/23.
 */
public class fragment_map extends BaseFragment {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private CheckBox cb_WXshare;
    private static final String App_id = "wx3adcf9377585fb93";//应用程序的ID
    private IWXAPI api;

    @Override
    protected int getViewResid() {
        return R.layout.fragment_map;
    }

    @Override
    protected void init(final View view) {
        super.init(view);
        api = WXAPIFactory.createWXAPI(view.getContext(),App_id);
        //将App_id注册到微信中
        api.registerApp(App_id);
        cb_WXshare = (CheckBox) view.findViewById(R.id.cb_weixin);


        //高德地图
        button1 = (Button) view.findViewById(R.id.bt_map);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_map = new Intent(getActivity(),MapActivity.class);
                startActivity(intent_map);
            }
        });
        //动画效果
        button2 = (Button) view.findViewById(R.id.bt_amination);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_amination = new Intent(getActivity(), AminationActivity.class);
                startActivity(intent_amination);
            }
        });
        //登录微信
        button3 = (Button) view.findViewById(R.id.bt_WXlogin);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),String.valueOf(api.openWXApp()),Toast.LENGTH_LONG).show();
                api.openWXApp();//登录微信

            }
        });

        //向好友或者朋友圈发送文本
        button4 = (Button) view.findViewById(R.id.bt_WXshare);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(getContext());
                editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                editText.setText("默认分享文本");
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle("共享文本");
                //将Edittext与对话框绑定
                builder.setView(editText);
                builder.setMessage("请输入要分享的文本");
                builder.setPositiveButton("分享", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = editText.getText().toString();
                        if (text == null || text.length() == 0) {
                            return;
                        }
                        //步骤1：创建一个用于封装待分享文本的WXTextObject对象
                        WXTextObject textObject = new WXTextObject();
                        textObject.text = text;

                        //步骤2:创建WXMediaMessage对象，该对象用于android客户端向微信发送参数
                        WXMediaMessage msg = new WXMediaMessage();
                        msg.mediaObject = textObject;
                        msg.description = text;

                        //步骤3：创建一个用于请求微信客户端的SedMessageToWX.Req对象
                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        req.message = msg;
                        //设置请求唯一标识，自定义方法
                        req.transaction = buildTransaction("text");
                        //表示发送给朋友还是朋友圈：发送给朋友圈WXSceneTimeline;发送给朋友WXSceneSession;
                        req.scene = cb_WXshare.isChecked() ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;

                        //步骤4：发送给微信客户端
//                        Toast.makeText(getContext(), String.valueOf(api.sendReq(req)), Toast.LENGTH_LONG).show();
                        api.sendReq(req);
                    }
                });
                builder.setNegativeButton("取消",null);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    //为请求生成一个唯一标识
    public String buildTransaction(final String type){
        return (type == null)?String.valueOf(System.currentTimeMillis()):type + System.currentTimeMillis();
    }

}
