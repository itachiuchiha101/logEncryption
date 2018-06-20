package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
/**
 * Created by syahmed4 on 19/06/18. This is the worst
 * piece of code that has been ever written by the worst
 * coder on this planet, Please refrain from looking at this
 */
public class JSONConfig
{
    //Config file parameters
    private String inputLogFile;
    private String[] filterList;
    private String outputLogFile;

    //Setters and getters -- begin
    public void setInputLogFile(String inputLogFile) {
        this.inputLogFile = inputLogFile;
    }

    public void setFilterList(String[] filterList) {
        this.filterList = filterList;
    }

    public void setOutputLogFile(String outputLogFile) {
        this.outputLogFile = outputLogFile;
    }


    public String getInputLogFile() {return this.inputLogFile;}

    public String getOutputLogFile() { return this.outputLogFile ;}

    public String[] getFilterList() { return this.filterList; }

    //Setters and getters end


    //Singleton config object instance
    private static JSONConfig _instance = null;
    private JSONConfig()
    {};

    public static JSONConfig getInstance()
    {
        if(_instance == null)
        {
            _instance = new JSONConfig();
        }
        return _instance;
    }



    public void init()
    {

    }

    public void init(String configFileName) throws FileNotFoundException {
        try
        {
            Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
            JSONObject jo = (JSONObject) obj;
            setInputLogFile((String) jo.get("inputLogFile"));
            setOutputLogFile((String) jo.get("outputLogFile"));
            JSONArray jFilterArray = (JSONArray)jo.get("filterList");

            String[] sFilterArray = new String[jFilterArray.size()];
            for(int i = 0 ; i < jFilterArray.size() ; i++)
            {
                String filterString = jFilterArray.get(i).toString();
                sFilterArray[i] = filterString;

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }


    }
}

