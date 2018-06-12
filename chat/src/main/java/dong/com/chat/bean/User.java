package dong.com.chat.bean;
import cn.bmob.v3.BmobUser;
/**
 * 创建日期：2018/6/12 on 14:42
 * 描述:
 * 作者:yuxd Administrator
 */

public class User extends BmobUser {

    private String avatar;

    public User(){}

    public User(NewFriend friend){
        setObjectId(friend.getUid());
        setUsername(friend.getName());
        setAvatar(friend.getAvatar());
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
