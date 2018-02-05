package com.platform.bookshare.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by Zhangchen on 2018/2/5.
 */

public class ShopInfoFragment extends BaseFragment {

    private ImageView img_title;
    private TextView tv_title,tv_author,tv_price,tv_publisher,tv_show;

    @Override
    public int getResource() {
        return R.layout.activity_book_info;
    }

    @Override
    public void init(View view) {
        AutoUtils.auto(view);
        img_title = (ImageView) view.findViewById(R.id.book_img);
        tv_title = (TextView) view.findViewById(R.id.book_title);
        tv_author = (TextView) view.findViewById(R.id.book_author);
        tv_price = (TextView) view.findViewById(R.id.book_price);
        tv_publisher = (TextView) view.findViewById(R.id.book_publisher);
        tv_show = (TextView) view.findViewById(R.id.textView3);

    }

    @Override
    public void loadingDatas() {
        Glide.with(getActivity()).load("https://img1.doubanio.com/mpic/s28888458.jpg").centerCrop().into(img_title);
        tv_title.setText("书名： 太平天国");
        tv_author.setText("作者： 陶短房");
        tv_price.setText("价格： 6.9");
        tv_publisher.setText("出版社： 陶短房");
        tv_show.setText("前所未有， 一套关于太平天国的百科全书式历史作品；《 说天国》 三部曲， 历史因清晰而有趣的细节活起来。\n" +
                "\t这是中国人熟悉却又常常误解的一段近代史！ 有人热捧有人臭骂的太平天国， 到底是什么样子？ 太平天国是先进的农民起义运动， 还是带来浩劫的“ 魔鬼的化身”（ 马克思语）？ 洪秀全的文才有多高？ 他有代笔吗？ 他是恋童癖？…… 太多问题我们特想知道， 而历史学者又语焉不详——《 说天国》 三部曲将告诉我们清晰而有趣的历史细节！《 说天国： 洪秀全真相》 为陶短房力作《 说天国》 系列之第三部， 从历史的细节剖析太平天国革命领袖洪秀全的方方面面： 洪秀全的文化水平到底有多高？ 他在金田起义前究竟有什么“ 革命事迹”？ 他的“ 革命大志” 是怎么产生的， 又有什么变化？ 洪秀全为何成了一个超级“ 宅男”？ 天国后期有一个顽童朝廷， 难道洪秀全是“ 恋童癖”？ 洪秀全有没有“ 代笔”？…… 作者娓娓道来， 给我们呈现出一个丰富的天王形象， 与教科书中的常见描述大不一样， 让人对太平天国运动产生深思。【 评论推荐】\n" +
                "\t初见陶短房写的历史随笔， 感觉非常不同。 他的文字， 若非在史海里浸润多年， 无论笔下如何生花， 都办不来的。—— 历史学家 张鸣\n" +
                "\t太平天国像是笼罩在一团迷雾中， 经常让人感觉是神神鬼鬼的， 难得作者梳理得这般清晰， 其中花费的坐冷板凳的功夫， 怕是难于人言， 佩服佩服。—— 作家 张永久\n" +
                "\t陶短房这本书， 也是严肃的祛魅， 是对普通读者的历史科普， 其中对洪秀全的描述， 是令人捧腹的喜剧， 那真是一个极品皇帝。—— 专栏作家 潘采夫\n" +
                "\t作为一本通俗历史读物， 陶短房这本书语言活泼有趣， 将一般读者比较好奇的问题作了清楚的回答， 对一些人物的来龙去脉作了梳理…… 在评人上比较公允和客观， 摆脱了以前意识形态的诸多成见。—— 学者 诗人 周伟驰\n" +
                "\t作者行文中不断对一直以来太平天国研究中产生的歧见辨疑析理， 此等文字风格并非“ 我在说书”， 而是有如设置了一个“ 假想敌”， 宾主都正襟危坐， 两造诘难。 这本书的“ 娱乐性” 来自于史料本身和作者幽默的评述， 但本质里它是一本非常严肃而严谨的史学著作。—— 作家 雍容\n" +
                "\t这本书说的是太平天国旧事， 可内容却相当八卦， 各种闻所未闻的趣事， 信手拈来—— 简直要让人怀疑作者是否当年在天京做过小报记者， 不然怎么能挖出如此之多的东西来。—— 读者 加里波第\n" +
                "\t可以说这是市面上可见的、 最客观论述太平天国历史的， 而且有趣的读物。 一直以来， 太平天国都被历史教材符号化了，（ 读陶短房的作品） 正好还原一个真实的复杂的历史， 摆脱高中教材设下的桎梏。—— 读者 杨行 " );
    }

    @Override
    public void startdestroy() {

    }
}
