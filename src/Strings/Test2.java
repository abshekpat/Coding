package Strings;
import io.rest

//{
//    "users" : [{
//      "id" : "user.id",
//      "operations" : [{
//        "op" : "replace",
//        "field" : "state",
//        "value" : {
//          "current" : "ACTIVE",
//          "prev": "ADDED",
//          "timestamp" :123
//        }
//      }]
//    }],
//    "scope": {
//      "company": "cname"
//   }
// }

public class Test2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RestAssured given = "http://www.ggogle.com"
         JSONObject  js= new JSONObject(response);
        JSONArray js1 = js.getJSONArray("users");
        for(int i=0;i<js1.length();i++)
        {
            JSONObject a1 = js1.getJSONObject(i).getJSONObject();
            String id = a1.getString("id");
            JSONArray a2 = a1.getJSONArray("operations");
            for(int j=0;j<a2.length();j++)
            {
                JSONObject a3 = a2.getJSONObject(j).getJSONObject();
                String time = a2.getJSONObject("value").getString("timestamp");
            }
        }
        System.out.print(js1.getJSONObject(users));
        .

    }

}
