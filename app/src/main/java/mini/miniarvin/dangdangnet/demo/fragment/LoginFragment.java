package mini.miniarvin.dangdangnet.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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
public class LoginFragment extends Fragment {


    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    RegisterFragment registerFragment=null;
    FragmentManager fManager=null;
    FragmentTransaction fTransaction=null;

    RequestQueue loginQueue = null;
    String name = "";
    String password = "";
    String url = "http://172.20.10.6:8080/myorderfood/login";
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginQueue= Volley.newRequestQueue(getActivity());
        mLoginFormView=inflater.inflate(R.layout.fragment_login, container, false);
        mEmailView = (AutoCompleteTextView) mLoginFormView.findViewById(R.id.name);
        mPasswordView = (EditText) mLoginFormView.findViewById(R.id.password);

        Button mEmailSignInButton = (Button) mLoginFormView.findViewById(R.id.name_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                attemptLogin();
                Log.e("TAG", "11111111111111111111111111111111111");
                name = mEmailView.getText().toString();
                password = mPasswordView.getText().toString();

                Map<String,String> myValue=new HashMap<String, String>();
                myValue.put("type","android");
                myValue.put("name",name);
                myValue.put("password",password);

                JSONObject myParams=new JSONObject(myValue);
                Log.e("TAG","151515151515");

                JsonObjectRequest loginRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        url,
                        myParams,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    Log.e("TAG","161616161");
                                    boolean isLogin=jsonObject.getBoolean("isLogin");
                                    if (isLogin){
                                        Log.e("TAG",isLogin+"");
                                        Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(getActivity(), "登录失败,\n密码或账号错�?", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.e("TAG", "21212121");
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        String msg= volleyError.getMessage();
                        Log.e("TAG",msg);
                    }
                });
                Log.e("TAG","3333333333333");
                loginQueue.add(loginRequest);
            }
        });

        Button mEmailRegisterButton= (Button)mLoginFormView.findViewById(R.id.name_register_button);
        mEmailRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fManager=getActivity().getSupportFragmentManager();
                fTransaction=fManager.beginTransaction();
                if(registerFragment==null){
                    registerFragment=new RegisterFragment();
                }
                fTransaction.replace(R.id.login_form,registerFragment);
                fTransaction.commit();
            }
        });


        mLoginFormView = mLoginFormView.findViewById(R.id.login_form);
        mProgressView = mLoginFormView.findViewById(R.id.login_progress);

        return mLoginFormView;
    }

}
