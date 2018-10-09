package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.* ;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App
{
    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;

        for (int elt : array) {
            if (elt == e) return true;
        }
        return false;
    }

    public static String[] computeMyResult( ArrayList<Integer> arr1 , ArrayList<Integer> arr2 , int a , int b ){
        int k = 0 , len = Math.min( a , arr1.size() ) + Math.min( b , arr2.size() ) ;
        if( len == 0 ) len = 1 ;
        String[] result = new String[len] ;
        for(int i = 0; i<a && i < arr1.size() ; i++ )
            result[k++] = arr1.get( i ).toString() ;
        for( int i=0 ; i<b && i < arr2.size() ; i++ )
            result[k++] = arr2.get( i ).toString() ;

        result[0] = "[" + result[0] ;
        result[len-1] = result[len-1] + "]" ;
        for( int i=0 ; i < len-1 ; i++ ) result[i] += ", " ;
        return result;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            ArrayList<Integer> arr1 = new ArrayList<Integer>() , arr2 = new ArrayList<Integer>() ;
            int a , b ;
            String input1 = req.queryParams("input1");
            String input2 = req.queryParams("input2");
            String input3 = req.queryParams("input3");
            String input4 = req.queryParams("input4");
            Scanner sc1 = new java.util.Scanner(input1);
            Scanner sc2 = new java.util.Scanner(input2);
            while( sc1.hasNextInt() ) arr1.add( sc1.nextInt() ) ;
            while( sc2.hasNextInt() ) arr2.add( sc2.nextInt() ) ;
            a = Integer.parseInt(input3.replaceAll("\\s",""));
            b = Integer.parseInt(input4.replaceAll("\\s",""));
            sc1.close();
            sc2.close();
            //sc1.useDelimiter("[;\r\n]+");
            //java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            //while (sc1.hasNext())
            //{
            //    int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            //    inputList.add(value);
            //}
            //System.out.println(inputList);

            //int input2AsInt = Integer.parseInt(input2);

            //boolean result = App.search(inputList, input2AsInt);

            String[] result = computeMyResult( arr1 , arr2 , a , b ) ;

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
