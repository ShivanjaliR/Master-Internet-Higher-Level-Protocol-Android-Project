package com.example.shivanjali.ubermanagement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Shivanjali on 11/14/2015.
 */
public class Background extends AsyncTask<String,String,String> {
    AlertDialog alert_dialog;
    Context ctx;
    Background(Context ctx)
    {
       this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {
        alert_dialog=new AlertDialog.Builder(ctx).create();
        //alert_dialog.setTitle("Login Information.......");
    }

    @Override
    protected String doInBackground(String... params) {
        int flag=0;
        String reglink="http://10.0.2.2/webapp/registration.php";
        String login="http://10.0.2.2/webapp/login.php";
        String addlocation="http://10.0.2.2/webapp/addlocation.php";

        String method=params[0];
        if(method.equals("Register"))
        {
            String name=params[1];
            String conno=params[2];
            String mailid=params[3];
            String username=params[4];
            String password=params[5];
            try {
                URL url=new URL("http://10.0.2.2/webapp/registration.php");
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                con.setDoInput(true);
                con.connect();
                OutputStream os=con.getOutputStream();
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("Name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("ConNo","UTF-8")+"="+URLEncoder.encode(conno,"UTF-8")+"&"+
                        URLEncoder.encode("Maildid","UTF-8")+"="+URLEncoder.encode(mailid,"UTF-8")+"&"+
                        URLEncoder.encode("Username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is=con.getInputStream();
                is.close();
                return "Registration Successfully";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else {
            if (method.equals("Login"))
            {
                String user_name = params[1];
                String password = params[2];
                URL url = null;
                try {
                    url = new URL("http://10.0.2.2/webapp/login.php");
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    con.connect();
                    OutputStream os = con.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    String data= URLEncoder.encode("UserName","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                            URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    bw.write(data);
                    bw.flush();
                    InputStream is=con.getInputStream();
                    BufferedReader buffer_reader=new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                    String line = "";
                    String response="";
                    while((line=buffer_reader.readLine())!=null)
                    {
                        response+=line;

                    }//end of while
                    buffer_reader.close();
                    is.close();
                    bw.close();
                    os.close();
                    return response;
                  } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            else
            {
                if (method.equals("Add_Location")) {

                    String source = params[1];
                    String destination = params[2];
                    String cabtype = params[3];
                    String date = params[4];
                    String time = params[5];
                    try {
                        URL url = new URL("http://10.0.2.2/webapp/addlocation.php");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.setDoOutput(true);
                        con.setDoInput(true);
                        con.connect();
                        OutputStream os = con.getOutputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                        String data = URLEncoder.encode("Source", "UTF-8") + "=" + URLEncoder.encode(source, "UTF-8") + "&" +
                                URLEncoder.encode("Destination", "UTF-8") + "=" + URLEncoder.encode(destination, "UTF-8") + "&" +
                                URLEncoder.encode("CabType", "UTF-8") + "=" + URLEncoder.encode(cabtype, "UTF-8") + "&" +
                                URLEncoder.encode("Date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8") + "&" +
                                URLEncoder.encode("Time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8");

                        bw.write(data);
                        bw.flush();
                        bw.close();
                        os.close();
                        InputStream is = con.getInputStream();
                        is.close();
                        return "Thanks for booking.Driver will arrive within 5 mins";
                    }//end of try
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }//end of catch
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }//end of catch
                }//end of if
            }//end of else
        }//end of if

            return null;

    }//end of doInBackground

    protected  void onProgressUpdate(String value)
    {
        super.onProgressUpdate(value);
    }//end of OnProgressUpdate


    protected void onPostExecute(String result)
    {
        if(result.equals("Registration Successfully"))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();

        }
        else
        {
            alert_dialog.setMessage(result);
            alert_dialog.show();
            Intent i = new Intent(this.ctx,BookCar.class);
            ctx.startActivity(i);
        }
        if(result.equals("Thanks for booking.Driver will arrive within 5 mins"))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }
     /*   else
        {
            alert_dialog.setMessage("Try to Login");
            alert_dialog.show();
            Intent i=new Intent(this.ctx,MainActivity.class);
            ctx.startActivity(i);
        }//end of else*/
    }//end of doPost
}//end of class
