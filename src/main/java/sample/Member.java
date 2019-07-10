package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Member {
    public Object Status;
    private String username;
    private String password;
    private String fullname;
    private String avatar;
    private Long remaintime;
    private int status;
    private ImageView imageAvatar;
 public Member(String text, String txtRemaintimeText, String txtAvatarText) {

 }
    public Member(String username, String avatar, Long remaintime) {
        this.username = username;
        this.avatar = avatar;
        this.remaintime = remaintime;
        this.imageAvatar = new ImageView(new Image(this.avatar, true)); // đưa ảnh vào image view.
        this.imageAvatar.setFitWidth(50); // set kích thước.
        this.imageAvatar.setFitHeight(50);

    }

    public Object getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ImageView getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(ImageView imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    public void setStatus(Object status) {
        Status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRemaintime() {
        return remaintime;
    }

    public void setRemaintime(Long remaintime) {
        this.remaintime = remaintime;
    }
}
