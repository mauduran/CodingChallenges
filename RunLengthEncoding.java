
public class RunLengthEncoding {

    public static String decode(String encodedMessage){
        String str = "";
        String num = "";

        for(int i=0; i<encodedMessage.length(); i++){
            char temp = encodedMessage.charAt(i);
            if(temp>='0' && temp<'9'){
                num += Character.toString(temp);
            } else{
                if(num.length()<1) return "Error";
                
                int number = Integer.parseInt(num);
                for(int j=0; j<number; j++){
                    str += Character.toString(temp);
                }
                num = "";

            }
        }
        return str;
    }

    public static String encode(String message){
        String str = "";

        if(message.equals("")) return str;

        int currentChar = message.charAt(0);
        int count = 1;

        for(int i=1; i<message.length();i++){
            char temp = message.charAt(i);
            if(temp==currentChar){
                count++;
            } else{
                str += Integer.toString(count);
                str += Character.toString(currentChar);
                currentChar = temp;
                count = 1;
            }  
        }
        str += Integer.toString(count);
        str += Character.toString(currentChar);

        return str;
    }

    public static void main(String[] args) {
        System.out.println(encode("AAAABBBCCDAA"));
        System.out.println(decode("3A4B10C1E2F"));
    }
}