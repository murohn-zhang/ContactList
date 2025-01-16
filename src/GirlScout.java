public class GirlScout extends Person {
    // Instance variable
    private int cookies;

    // Constructor
    public GirlScout(String first, String last, String number, int cookies) {
        super(first, last, number);
        this.cookies = cookies;
    }

    // Getter
    public int getCookies() {
        return cookies;
    }

    // toString
    public String toString() {
        return super.toString() + " Cookies Sold: " + cookies;
    }


}
