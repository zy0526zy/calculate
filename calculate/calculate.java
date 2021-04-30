package calculate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class calculate 
{
	public static String s= new String();
	public static int n;
	//下面的方法为分式化解
    public static String simplification(int a,int b)
    {
        int y = 1;
        for(int i=a;i>=1;i--)
        {
            if(a%i==0&&b%i==0)
            {
                y = i;
                break;
            }
        }
        int z = a/y;
        int m = b/y;
        if(z==0)  
            return "0";
        if(m==1)
        	return ""+z;
        return z+"/"+m;
    }     
    //下面的方法为随机产生加减乘除的字符
    public static String Sign(int a)
    {
    	if(a==0)
    		return "+";
    	if(a==1)
    		return "-";
    	if(a==2)
    		return "*";
    	if(a==3)
    		return "/";
    	return "";
    }
    //下面为3个运算数的运算式的产生方法；
    public static String threenum(int num1,int num2,int num3)
    {
    	String s1= new String();
        int sign1=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
        int sign2=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
        int sign3=(int)(Math.random()*2);//如果是1表示有括号，如果是0 表示无括号
        int sign4=(int)(Math.random()*2);//如果是1表示产生分式，如果是0 表示整式。
        if(sign1==sign2)
        {
        	sign2=(sign1+1)%3;//保证两个运算符不相同。
        }
        if(sign3==0)//表示无括号
        {
        	//下面的过程为排除，除不整的，还有分母为0，
            if(sign1==3)
            {
            	if(num2==0)//如果分母为0
            		num2=1+(int)(Math.random()*100);//随机生成一个1-100的整数
            	while(num1%num2!=0)
            	{
            		num1=(int)(Math.random()*100);
            	}
            }
            if(sign2==3)
            {
            	if(num3==0)//如果分母为0
            		num3=1+(int)(Math.random()*100);//随机生成一个1-100的整数
            	while(num2%num3!=0)
            	{
            		num2=(int)(Math.random()*100);
            	}
            }
            s1= num1+Sign(sign1)+num2+Sign(sign2)+num3+"=";
            return s1;	
        }
        else  //表示有括号
        {
        	int location=(int)(Math.random()*1);//如果是0表示括号在前，如果是1 表示括号在后。
        	if(location==0)
        	{
        		if(sign1==3)
        		{
        			if(num2==0)//如果分母为0
        				num2=1+(int)(Math.random()*100);//随机生成一个1-100的整数
        			while(num1%num2!=0)
        			{
        				num1=(int)(Math.random()*100);
        			}
        		}
        		if(sign2==3)
        		{
        			if(num3==0)//如果分母为0
        				num3=1+(int)(Math.random()*100);//随机生成一个1-100
        			if(sign1==0)
        			{
        				while((num1+num2)%num3!=0)
        				{
        					num3=1+(int)(Math.random()*100);
        				}
        			}
        			if(sign1==1)
        			{
        				while((num1-num2)%num3!=0)
        				{
        					num3=1+(int)(Math.random()*100);
        				}
        			}
        			if(sign1==2)
        				while((num1*num2)%num3!=0)
        				{
        					num3=1+(int)(Math.random()*100);
        				}
        		}
        		s1= "("+num1+Sign(sign1)+num2+")"+Sign(sign2)+num3+"=";  	
        	if(location==1)
        		if(sign2==3)
        		{
        			if(num3==0)//如果分母为0
        				num3=1+(int)(Math.random()*100);//随机生成一个1-100的整数
        			while(num2%num3!=0)
        			{
        				num2=(int)(Math.random()*100);
        			}
        		}
        		if(sign1==3)//如果括号在后面切第一个符号位/
                {
                	if(sign2==0)
                	{
                		if(num2==0&&num3==0)
                			num3=1+(int)(Math.random()*100);//随机生成一个1-100的整数
                		while(num1%(num2+num3)!=0)
                			num1=(int)(Math.random()*100);
                	}
                	if(sign2==1)
                	{
                		if(num2==num3)   //两个数相减为0了，在除数上
                			num2=num3+1+(int)(Math.random()*100);
                		while(num1%(num2-num3)!=0)
                		num1=(int)(Math.random()*100);
                	}
                	if(sign2==2)
                	{
                		if(num2==0)
                			num2=1+(int)(Math.random()*100);
                		if(num3==0)
                			num3=1+(int)(Math.random()*100);
                		while(num1%(num2*num3)!=0)
                			num1=(int)(Math.random()*100);
                	}
                	s1= num1+Sign(sign1)+"("+num2+Sign(sign2)+num3+")"+"=";  
                }	     		
        		return s1;
        	}
        }
        return s1;               	
    }
    //下面为4个运算数的运算式的产生方法；
    public static String fournum(int num1,int num2,int num3,int num4)
    {
    	String s1= new String();
    	int sign1=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
        int sign2=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
        int sign3=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
        if(sign1==sign2)
        	sign2=(sign1+1)%3;//保证两个运算符不相同。
        if(sign2==sign3)
        	sign3=(sign2+1)%3;//保证两个运算符不相同。
        //下面的过程为排除，除不整的，还有分母为0，
        if(sign1==3)
        {
        	if(num2==0)//如果分母为0
        		num2=1+(int)(Math.random()*100);//随机生成一个1-100的整数
        	while(num1%num2!=0)
        	{
        		num1=(int)(Math.random()*100);
        	}
        }
        if(sign2==3)
        {
        	if(num3==0)//如果分母为0
        		num3=1+(int)(Math.random()*100);//随机生成一个1-100的整数
        	while(num2%num3!=0)
        	{
        		num2=(int)(Math.random()*100);
        	}
        }
        if(sign3==3)
        {
        	if(num4==0)//如果分母为0
        		num4=1+(int)(Math.random()*100);//随机生成一个1-100的整数
        	while(num3%num4!=0)
        	{
        		num3=(int)(Math.random()*100);
        	}
        }
        s1= num1+Sign(sign1)+num2+Sign(sign2)+num3+Sign(sign3)+num4+"=";
        return s1;
    }
    //下面为5个运算数的运算式的产生方法；
    public static String fivenum(int num1,int num2,int num3,int num4,int num5)
    {
    	String s1= new String();
    	int sign1=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
    	int sign2=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
    	int sign3=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
    	int sign4=(int)(Math.random()*4);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
    	if(sign1==sign2)
    		sign2=(sign1+1)%3;//保证两个运算符不相同。
    	if(sign2==sign3)
    		sign3=(sign2+1)%3;//保证两个运算符不相同。
    	if(sign3==sign4)
    		sign4=(sign3+1)%3;//保证两个运算符不相同。
    	//下面的过程为排除，除不整的，还有分母为0，
    	if(sign1==3)
    	{
    		if(num2==0)//如果分母为0
    			num2=1+(int)(Math.random()*100);//随机生成一个1-100的整数
    		while(num1%num2!=0)
    		{
    			num1=(int)(Math.random()*100);
    		}
    	}
    	if(sign2==3)
    	{
    		if(num3==0)//如果分母为0
    			num3=1+(int)(Math.random()*100);//随机生成一个1-100的整数
    		while(num2%num3!=0)
    		{
    			num2=(int)(Math.random()*100);
    		}
    	}
    	if(sign3==3)
    	{
    		if(num4==0)//如果分母为0
    			num4=1+(int)(Math.random()*100);//随机生成一个1-100的整数
    		while(num3%num4!=0)
    		{
    			num3=(int)(Math.random()*100);
    		}
    	}
    	if(sign4==3)
    	{
    		if(num5==0)//如果分母为0
    			num5=1+(int)(Math.random()*100);//随机生成一个1-100的整数
    		while(num4%num5!=0)
    		{
    			num4=(int)(Math.random()*100);
    		}
    	}
    	s1= num1+Sign(sign1)+num2+Sign(sign2)+num3+Sign(sign3)+num4+Sign(sign4)+num5+"=";
    	return s1; 
    }
//====================================================================================
//下面的方法为利用逆波兰的方法排除生成式子为负数的情况并算出表达式的结果
    public static int jisuan(String s)
    {	
    	Stack<Integer> stack1 = new Stack<Integer>();//放数字
    	Stack<String> stack2 = new Stack<String>();//放操作符
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();//存放运算符优先级的
    	hashmap.put("(", 0);
    	hashmap.put("+", 1);
    	hashmap.put("-", 1);
    	hashmap.put("*", 2);
    	hashmap.put("/", 2);
    	for (int i = 0; i < s.length();) 
    	{
    		StringBuffer digit = new StringBuffer();  //StringBuffer类中的方法主要偏重于对于字符串的变化，
    		//例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别。
    		char c = s.charAt(i);//将式子字符串切割为c字符
    		while (Character.isDigit(c)) 
    		{//判断字符是否为10进制数字,将一个数加入digit
    			digit.append(c);
    			i++;
    			c = s.charAt(i);
    		}
    		if (digit.length() == 0) 
    		{  //当前digit里面已经无数字，即当前处理符号
    			switch (c)
    			{
    			case '(': 
    			{
    				stack2.push(String.valueOf(c));//如果是（   转化为字符串压入字符栈
    				break;
    			}
    			case ')': 
    			{//遇到右括号了计算，因为（的优先级最高
    				String stmp = stack2.pop();//如果是），将符号栈栈顶元素取到
    				while (!stack2.isEmpty() && !stmp.equals("(")) 
    				{ //当前符号栈里面还有+ - * /
    					int a = stack1.pop();  //取操做数a,b
    					int b = stack1.pop();
    					int sresulat = calculate(b, a, stmp);//计算
    					if(sresulat<0)
    						return  -1;
    					stack1.push(sresulat);//将结果压入栈
    					stmp = stack2.pop();//符号指向下一个计算符号
    				}
    				break;
    			}
    			case '=': 
    			{//遇到等号了计算，
    				String stmp;
    				while (!stack2.isEmpty()) 
    				{//当前符号栈里面还有+ - * /,即还没有算完
    					stmp = stack2.pop();
    					int a = stack1.pop();
    					int b = stack1.pop();
    					int sresulat = calculate(b, a, stmp);
    					if(sresulat<0)
    						return  -1;
    					stack1.push(sresulat);
    				}
    				break;
    			}
    			default: 
    			{  //不满足之前的任何情况
    				String stmp;
    				while (!stack2.isEmpty()) 
    				{ //如果符号栈有符号
    					stmp = stack2.pop(); //当前符号栈，栈顶元素
    					if (hashmap.get(stmp) >= hashmap.get(String.valueOf(c))) {//比较优先级
    						int a = stack1.pop();
    						int b = stack1.pop();
    						int sresulat =calculate (b, a, stmp);
    						if(sresulat<0)
    							return  -1;
    						stack1.push(sresulat);
    					} 
    					else 
    					{
    						stack2.push(stmp);
    						break;
    					}
    				}
    				stack2.push(String.valueOf(c));  //将符号压入符号栈
    				break;
    			}
    			}
    		} 
    		else 
    		{//处理数字，直接压栈
    			stack1.push(Integer.valueOf(digit.toString()));
    			continue;
    		}
    		i++;
    	}
    	return stack1.peek();  //返回栈底数字即等式的答案。
    }
    public static int calculate(int a, int b, String stmp) 
    {//计算a stmp b的值
    	int res = 0;//存结果
    	char s = stmp.charAt(0);
    	switch (s)
    	{
    	case '+': 
    	{
    		res = a + b;
    		break;
    	}
    	case '-': 
    	{
    		res = a - b;
    		break;
    	}
    	case '*':
    	{
    		res = a * b;
    		break;
    	}
    	case '/': 
    	{
    		if(b==0)
    			return -1;
    		else
    			res = a / b;
    		break;
    	}
    	}
    	return res;
    }
}