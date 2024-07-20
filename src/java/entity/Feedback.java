package entity;

/**
 *
 * @author ADMIN
 */
public class Feedback {

    private String fb_id;
    private String fb_content;
    private String fb_date;
    private String acc_id;

    public Feedback() {
    }

    public Feedback(String fb_id, String fb_content, String fb_date, String acc_id) {
        this.fb_id = fb_id;
        this.fb_content = fb_content;
        this.fb_date = fb_date;
        this.acc_id = acc_id;
    }

    public String getFb_id() {
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        this.fb_id = fb_id;
    }

    public String getFb_content() {
        return fb_content;
    }

    public void setFb_content(String fb_content) {
        this.fb_content = fb_content;
    }

    public String getFb_date() {
        return fb_date;
    }

    public void setFb_date(String fb_date) {
        this.fb_date = fb_date;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    @Override
    public String toString() {
        return "Feedback{" + "fb_id=" + fb_id + ", fb_content=" + fb_content + ", fb_date=" + fb_date + ", acc_id=" + acc_id + '}';
    }

}
