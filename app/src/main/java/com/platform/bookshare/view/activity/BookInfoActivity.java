package com.platform.bookshare.view.activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.platform.bookshare.R;
import com.platform.bookshare.config.UrlConfig;
import com.platform.bookshare.model.BookInfoModel;
import com.platform.bookshare.utils.KJHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.ui.BindView;

//import com.alibaba.fastjson.JSON;


public class BookInfoActivity extends BaseActivity {

    private static final String TAG = "BookInfoActivity";
    public String isbn = "";
    private String result ="";
    private BookInfoModel bim;

    @BindView(id = R.id.textView3,click = true)
    private TextView content_tv;
    @BindView(id = R.id.book_img,click = true)
    private ImageView bImg_iv;
    @BindView(id = R.id.book_title)
    private TextView bName_tv;
    @BindView(id = R.id.book_price)
    private TextView bPrice_tv;
    @BindView(id = R.id.book_author)
    private TextView bAuthor_tv;
    @BindView(id = R.id.book_publisher)
    private TextView bPub_tv;

    private DisplayImageOptions options;

    @Override
    public void setRootView() {
        super.setRootView();
        setContentView(R.layout.activity_book_info);
    }

    @Override
    public void initData() {
        super.initData();
        isbn = this.getIntent().getStringExtra("isbnNum");
//        options = new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(20)).build();
        handler.sendEmptyMessage(0);

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    if(isbn.length()>0){
                        KJHttpUtil.getBookByIsbn(BookInfoActivity.this, UrlConfig.ISBNINFO+isbn, null, true,callBack);
                    }
                    break;
                case 1:
                    System.out.println("imd = "+bim.getImages()[2]);
                    ImageLoader.getInstance().displayImage(bim.getImages()[2], bImg_iv);
                    bName_tv.setText("书名："+bim.getTitle());
                    bPrice_tv.setText("价格:"+bim.getPrice());
                    bAuthor_tv.setText("作者："+bim.getAuthor());
                    bPub_tv.setText("出版社："+bim.getPublisher());
                    content_tv.setText("简介："+bim.getSummary());
                    break;
            }
        }
    };

    HttpCallBack callBack = new HttpCallBack() {
        @Override
        public void onPreStart() {
            super.onPreStart();
            Log.i(TAG, "联网了...");
        }

        @Override
        public void onSuccess(String t) {
            super.onSuccess(t);
            result = t;
            if (t != null && t.trim().length() > 0) {
                // TODO 登录回调
                Log.i(TAG, "登录回调：" + t);

                bim = new BookInfoModel();

                JSONObject objetStr = null;
                try {
                    objetStr = new JSONObject(t);

                    bim.setTitle(objetStr.getString("title"));

                    JSONObject images = objetStr.getJSONObject("images");
                    String[] temp = new String[3];
                    temp[0] = images.getString("small");
                    temp[1] = images.getString("medium");
                    temp[2] = images.getString("large");
                    bim.setImages(temp);

                    bim.setPrice(objetStr.getString("price"));

                    bim.setAuthor(objetStr.getString("author"));

                    JSONArray authors = objetStr.getJSONArray("author");
                    StringBuffer auth = new StringBuffer();
                    for(int x = 0 ; x < authors.length() ; x++){
                        if(x == authors.length() -1){
                            auth.append(authors.getString(x));
                        }else{
                            auth.append(authors.getString(x)+",");
                        }
                    }
                    bim.setAuthor(auth.toString());

                    bim.setPublisher(objetStr.getString("publisher"));

                    bim.setSummary(objetStr.getString("summary"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                handler.sendEmptyMessage(1);

            } else {
                Log.i(TAG, "登录回调为空！");
            }
        }

        @Override
        public void onFailure(int errorNo, String strMsg) {
            super.onFailure(errorNo, strMsg);
            // TODO 登录失败
            Log.i(TAG, "登录失败：" + strMsg);
        }
    };

}
