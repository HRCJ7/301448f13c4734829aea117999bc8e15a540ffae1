package com.example.rajithaperera.mercari;

import android.content.Context;
import android.support.v4.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by rajithaperera on 12/12/17.
 */

public class BaseFragment extends Fragment {

    public String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public ArrayList<Item> itemList(Context context, String jsonString)
    {
        ArrayList<Item> formList = new ArrayList<Item>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context,jsonString));
            JSONArray m_jArry = obj.getJSONArray("data");



            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Item item=new Item();
                item.setId(jo_inside.getString("id"));
                item.setName(jo_inside.getString("name"));
                item.setStatus(jo_inside.getString("status"));
                item.setNum_comments(jo_inside.getInt("num_comments"));
                item.setNum_likes(jo_inside.getInt("num_likes"));
                item.setPhoto(jo_inside.getString("photo"));
                item.setPrice(jo_inside.getInt("price"));

                //Add your values in your `ArrayList` as below:

                formList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return formList;
    }

}
