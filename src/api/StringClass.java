package api;

public class StringClass {

  public static void main(String[] args) {
    String username = "Tom";
    String username2 = "Jerry";

    System.out.println(username.compareTo(username2));
    System.out.println(username.concat("&Jerry"));




  }

  public static String getCode(int len) {
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder code = new StringBuilder();
    
    for (int i = 0; i < len; i++) {
      int idx = (int)(Math.random() * str.length());
      code.append(str.charAt(idx));
    }
    return code.toString();

  }

}
