package Strings;

public class WorkWithObjects {

    public static void main(String args[]) {

        Object[] obj = new Object[3];

        obj[0]=1;
        obj[1]="ab";
        obj[2]=-1;


        for(int i =0;i<obj.length;i++) {

//            Object Obj1 = obj[i];
//            int num= Integer.parseInt(Obj1.toString());
//            System.out.print(num);
//
//            if(num >0)
//                System.out.println(num);

            try {

                int num= Integer.parseInt(obj[i].toString());
                if(num>=1)
                System.out.println(obj[i]);
            }
            catch(Exception e) {

            }




        }

    }

}
