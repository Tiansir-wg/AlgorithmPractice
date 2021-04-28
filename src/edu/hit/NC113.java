package edu.hit;

/**
 * 验证IP地址
 *
 * https://www.nowcoder.com/practice/55fb3c68d08d46119f76ae2df7566880?tpId=117&tqId=37837&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC113 {
    public String solve (String IP) {
        if(IP == null || IP.length() == 0) {
            return "Neither";
        }
        if(validIPv4(IP)) return "IPv4";
        if(valirdIPv6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean validIPv4(String IP){
        String[] strs = IP.split("\\.");
        // IPv4地址包括四部分
        if(strs.length != 4) return false;
        // 每一个部分不能超过255,且长度大于1时不能以0开头
        for (String str : strs) {
            if(Integer.valueOf(str) > 255 || (str.length() > 1 && str.charAt(0) == '0')) return false;
        }
        return true;
    }

    public boolean valirdIPv6(String IP){
        String[] strs = IP.split(":");
        // IPv6地址包括八部分
        if(strs.length != 8) return false;
        for(String part : strs){
            if(part.length() > 4) return false;
        }
        return true;
    }
}
