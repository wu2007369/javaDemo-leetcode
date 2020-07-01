package leetcode;

public class RegularExpressionMatching_010 {
    /**
     *核心公式
     * P,S为字符串，P长度为j，S长度为i
     f(i,j)=f(i-1,j-1)&match(P[j-1],S[i-1]);//P[j-1]不为*
     f(i,j)=f(i,j-2) || f(i,j-1) || f(i-1,j)&&match(P[j-2],s[i-1]);//P[j-1]为*，含义分别为匹配0个，匹配1个，匹配多个

     match为普通字符 的匹配方法
     */
    public static void main(String[] args) {
        RegularExpressionMatching_010 obj = new RegularExpressionMatching_010();
        System.out.println(obj.isMatch("aa", "a"));//false
        System.out.println(obj.isMatch("aa", "a*"));//true
        System.out.println(obj.isMatch("ab", ".*"));//true
        System.out.println(obj.isMatch("aab", "c*a*b"));//true
        System.out.println(obj.isMatch("mississippi", "mis*is*p*"));//false
        System.out.println(obj.isMatch("aaa", "a*a"));//true
        System.out.println(obj.isMatch("aaa", "ab*a"));//false
        System.out.println(obj.isMatch("aaa", "ab*a*c*a"));//true
    }

    public boolean isMatch(String s, String p) {
        int i = s.length();
        int j = p.length();


        //初始化边界值****************************** start ***************************************
        //初始化，每一个值都是false
        boolean[][] results = new boolean[i + 1][j + 1];
        //两条空字符串，匹配是成功的
        results[0][0] = true;
        //s为空，p只有带*时的匹配可为true，其余情况为false不变
        for (int l = 2; l <= j; l++) {
            if (p.charAt((l) - 1) == '*' && results[0][l - 2]) {
                results[0][l] = true;
            }
        }
        //result[0-i][0]都是false
        //初始化边界值****************************** end ***************************************


        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (p.charAt((l) - 1) == '*') {
                    if (l >= 2) {
                        results[k][l] = (results[k][l - 2]) || (results[k][l - 1]) || (results[k - 1][l] && Match(p.charAt((l - 1) - 1), s.charAt((k) - 1)));
                    } else {
                        results[k][l] = (results[k][l - 1]) || (results[k - 1][l] && Match(p.charAt((l - 1) - 1), s.charAt((k) - 1)));
                    }
                } else {
                    results[k][l] = results[k - 1][l - 1] && Match(p.charAt((l) - 1), s.charAt((k) - 1));
                }

            }
        }

/*        for (int k=0;k<i;k++){
            for (int l=0;l<j;l++){
                System.out.print(results[k][l]+",");
            }
            System.out.println();
        }*/
        return results[i][j];
    }

    public static boolean Match(char pj, char si) {
        if (pj == '.') {
            return true;
        }
        if (pj == si) {
            return true;
        } else {
            return false;
        }
    }


}
