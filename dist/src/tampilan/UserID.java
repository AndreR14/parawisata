/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

/**
 *
 * @author ASUS
 */
public class UserID {
    private static String kd;
    private static String nama_user;
    
    public static String getUserLogin() {
        return kd;
    }
    
    public static void setUserLogin(String kode){
        kd=kode;
    }    
        public static String getNamaLogin() {
        return nama_user;
    }

    public static void setNamaLogin(String nnama_user) {
        nama_user = nnama_user;
    }
    
}
