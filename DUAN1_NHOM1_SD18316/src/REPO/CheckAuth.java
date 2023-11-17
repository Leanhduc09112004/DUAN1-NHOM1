
package REPO;

import MODEL.NhanVien;

public class CheckAuth {
     public  static NhanVien user = null;
    public static void clear(){
        CheckAuth.user = null;
    }
    public static boolean isLogin(){
        return CheckAuth.user != null;
    }
    public static boolean isManager(){
       return CheckAuth.isLogin()&& user.getChucVu();
    }
}
