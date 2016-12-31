package planhub.util;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by little_sheep on 2016/7/10.
 */
public class EncryptWithMD5 {

    public String makeMD5(String sourceData,String salt) {
        MessageDigest md;
        try {
            sourceData = sourceData+salt;
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数(指定编码格式，不以来默认编码)
            md.update(sourceData.getBytes("utf-8"));
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String pwd = new BigInteger(1, md.digest()).toString(16);
            //System.err.println(pwd);
            return pwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceData;
    }
}
