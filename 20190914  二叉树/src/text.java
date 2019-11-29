import java.util.ArrayList;

public class text {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        char []ch=new char[n];
        for(int i=1;i<n+1;i++)
        {
            ch=String.valueOf(i).toCharArray();
            for(int j=0;j<ch.length;j++)
            {
                if(ch[j]=='1') count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new text().NumberOf1Between1AndN_Solution(13));
    }
}
