package mini.miniarvin.dangdangnet.demo.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import mini.miniarvin.dangdangnet.demo.MainActivity;
import mini.miniarvin.dangdangnet.demo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private AutoCompleteTextView mNameView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mRegisterFormView;

    RequestQueue registerQueue=null;
    String name ="";
    String password="";
    String url="http://172.20.10.6:8080/myorderfood/register";

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        registerQueue= Volley.newRequestQueue(getActivity());
        mRegisterFormView=inflater.inflate(R.layout.fragment_register, container, false);
        mNameView = (AutoCompleteTextView)mRegisterFormView.findViewById(R.id.name);


        mPasswordView = (EditText) mRegisterFormView.findViewById(R.id.password);
        Button mRegisterConfirm= (Button) mRegisterFormView.findViewById(R.id.register_confirm);
        mRegisterConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=mNameView.getText().toString();
                password=mPasswordView.getText().toString();

                Map<String,String> myValue=new HashMap<String, String>();
                myValue.put("type","android");
                myValue.put("name",name);
                myValue.put("password",password);

                JSONObject myParams=new JSONObject(myValue);
                JsonObjectRequest registerRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        url,
                        myParams,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    boolean isRegister = jsonObject.getBoolean("isRegister");
                                    if(isRegister){
                                        Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                                        Intent registerIntent=new Intent(getActivity(),MainActivity.class);
                                        getActivity().startActivity(registerIntent);
                                    }else {
                                        Toast.makeText(getActivity(), "注册失败", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });

            }
        });

        Button mRegisterCancel= (Button) mRegisterFormView.findViewById(R.id.register_cancel);
        mRegisterCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mProgressView = mRegisterFormView.findViewById(R.id.login_progress);
        return mRegisterFormView;
    }

}
