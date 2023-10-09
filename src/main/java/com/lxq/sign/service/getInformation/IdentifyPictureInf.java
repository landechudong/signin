package com.lxq.sign.service.getInformation;

import com.baidu.aip.ocr.AipOcr;

import com.lxq.sign.dao.TimeDao;
import com.lxq.sign.domain.MainMessages;
import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.domain.Time;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@SuppressWarnings({"all"})
public class IdentifyPictureInf {
    //设置APPID/AK/SK
    public static final String APP_ID = "38446316";
    public static final String API_KEY = "mG0LLhVbPjbwxX66uuy20kNY";
    public static final String SECRET_KEY = "HuoaRnFwUjyPC9gbzsx4oePbBnjeuM5X";

    public static List<MainMessages> list = new LinkedList<MainMessages>();
    public static List<MainMessages> classList = new LinkedList<MainMessages>();
    public static List<StudentInf> stuList = new LinkedList<StudentInf>();
    public static String path = "";

    @Autowired
    TimeDao timeDao;

    public void getInformation(String picturePath) {



        if(!(path.equals(picturePath))) {
            classList.clear();
            stuList.clear();

            // 初始化一个AipOcr
            AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(20000);
            client.setSocketTimeoutInMillis(60000);

            // 调用接口
            String path = picturePath;
            JSONObject res = client.basicGeneral(path, new HashMap<String, String>());

            Object words_result = res.get("words_result");
            JSONArray words_result1 = res.getJSONArray("words_result");

            for (int i = 0; i < words_result1.length(); i++) {

                JSONObject wordsResultObj = words_result1.getJSONObject(i);
                String words = wordsResultObj.getString("words");

                if (words.length() > 15) {

                    String schedule = words.replace('，', ',');
                    schedule = schedule.replace("（","(");
                    schedule = schedule.replace("）",")");

                    System.out.println(schedule);

                    int i1 = schedule.indexOf("2022");
                    if(i1 != -1){
                        char c = schedule.charAt(i1 - 1);
                        if( c == '('){
                            char c1 = schedule.charAt(i1 - 2);
                            if(c1 == '('){
                                String part1 = schedule.substring(0, i1 - 2);  // 从开头到索引2（不包括2）
                                String part2 = schedule.substring(i1 - 1);
                                System.out.println(part1 + " " + part2);
                                schedule = part1  + part2;
                                System.out.println("????");
                            }
                        }else{
                            String part1 = schedule.substring(0, i1);  // 从开头到索引2（不包括2）
                            String part2 = schedule.substring(i1);
                            schedule = part1 + "(" + part2;

                        }
                    }

                    String pattern1 = "单(\\d+-\\d+),([\\u4E00-\\u9FFF]{2}),(\\d+-\\d+)节.*?";
                    String pattern2 = "双(\\d+-\\d+),([\\u4E00-\\u9FFF]{2}),(\\d+-\\d+)节.*?";
                    String pattern3 = "(\\d+-\\d+),([\\u4E00-\\u9FFF]{2}),(\\d+-\\d+)节.*?";
                    String pattern4 = "([\\u4E00-\\u9FFF]{3})(\\(\\d+\\))";
                    String pattern5 = "([\\u4E00-\\u9FFF]{2})(\\(\\d+\\))";

                    Pattern regexPattern4 = Pattern.compile(pattern4);
                    Matcher matcher4 = regexPattern4.matcher(schedule);

                    Pattern regexPattern5 = Pattern.compile(pattern5);
                    Matcher matcher5 = regexPattern5.matcher(schedule);

                    Pattern regexPattern1 = Pattern.compile(pattern1);
                    Matcher matcher1 = regexPattern1.matcher(schedule);

                    Pattern regexPattern2 = Pattern.compile(pattern2);
                    Matcher matcher2 = regexPattern2.matcher(schedule);

                    Pattern regexPattern3 = Pattern.compile(pattern3);
                    Matcher matcher3 = regexPattern3.matcher(schedule);


                    while (matcher1.find()) {
                        //单周
                        MainMessages mainMessages = new MainMessages();
                        String isSingle = "单";
                        String weekToWeek = matcher1.group(1);
                        String dayOfWeek = matcher1.group(2);
                        String classToClass = matcher1.group(3);

                        mainMessages.setIsSingle(isSingle);
                        mainMessages.setWeekToWeek(weekToWeek);
                        mainMessages.setDayOfWeek(dayOfWeek);
                        mainMessages.setClassToClass(classToClass);
                        list.add(mainMessages);
                    }
                    while (matcher2.find()) {
                        //双周
                        MainMessages mainMessages = new MainMessages();
                        String isSingle = "双";
                        String weekToWeek = matcher2.group(1);
                        String dayOfWeek = matcher2.group(2);
                        String classToClass = matcher2.group(3);

                        mainMessages.setIsSingle(isSingle);
                        mainMessages.setWeekToWeek(weekToWeek);
                        mainMessages.setDayOfWeek(dayOfWeek);
                        mainMessages.setClassToClass(classToClass);
                        list.add(mainMessages);
                    }

                    while (matcher3.find()) {
                        //不分单双周
                        MainMessages mainMessages = new MainMessages();
                        // String isSingle = "双";
                        String weekToWeek = matcher3.group(1);
                        String dayOfWeek = matcher3.group(2);
                        String classToClass = matcher3.group(3);

                        mainMessages.setIsSingle("全");
                        mainMessages.setWeekToWeek(weekToWeek);
                        mainMessages.setDayOfWeek(dayOfWeek);
                        mainMessages.setClassToClass(classToClass);
                        list.add(mainMessages);
                    }

                    while (matcher4.find()) {
                        //学生信息对象
                        StudentInf studentInf = new StudentInf();

                        String stuName = matcher4.group(1);
                        String stuCode = matcher4.group(2);

                        String substring = stuCode.substring(1, stuCode.length() - 1);

                        studentInf.setStuName(stuName);
                        studentInf.setStuCode(substring);
                        System.out.println(stuName+substring);
                        stuList.add(studentInf);
                    }
                    while (matcher5.find()) {
                        //学生信息对象
                        StudentInf studentInf = new StudentInf();

                        String stuName = matcher5.group(1);
                        String stuCode = matcher5.group(2);

                        String substring = stuCode.substring(1, stuCode.length() - 1);
                        studentInf.setStuName(stuName);
                        studentInf.setStuCode(substring);
                        System.out.println(stuName+substring);
                        stuList.add(studentInf);
                    }
                } else {
                    continue;
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getClassToClass().equals("11-12") || list.get(i).getClassToClass().equals("13-13")) {
                    list.remove(i);
                    i = i - 1;
                }
            }

            LinkedList<MainMessages> mainMessages1 = new LinkedList<MainMessages>();
            LinkedList<MainMessages> mainMessages2 = new LinkedList<MainMessages>();
            LinkedList<MainMessages> mainMessages3 = new LinkedList<MainMessages>();
            LinkedList<MainMessages> mainMessages4 = new LinkedList<MainMessages>();
            LinkedList<MainMessages> mainMessages5 = new LinkedList<MainMessages>();

            //对课程进行按节进入对应的集合
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getClassToClass().equals("1-2")) {
                    mainMessages1.add(list.get(i));
                } else if (list.get(i).getClassToClass().equals("3-4")) {
                    mainMessages2.add(list.get(i));
                } else if (list.get(i).getClassToClass().equals("5-6")) {
                    mainMessages3.add(list.get(i));
                } else if (list.get(i).getClassToClass().equals("7-8")) {
                    mainMessages4.add(list.get(i));
                } else if (list.get(i).getClassToClass().equals("9-10")) {
                    mainMessages5.add(list.get(i));
                }
            }

            //对课进行筛选
            for (int i = 0; i < mainMessages1.size(); i++) {
                for (int j = i + 1; j < mainMessages1.size(); j++) {
                    if (mainMessages1.get(i).getDayOfWeek().equals(mainMessages1.get(j).getDayOfWeek())) {
                        String[] split = mainMessages1.get(i).getWeekToWeek().split("-");
                        String[] split1 = mainMessages1.get(j).getWeekToWeek().split("-");
                        String classes = split[0] + "-" + split1[1];
                        mainMessages1.get(i).setWeekToWeek(classes);
                        if (mainMessages1.get(i).getIsSingle().equals("单")) {
                            mainMessages1.get(i).setIsSingle("全");
                            if (split1[1].equals("15")) {
                                mainMessages1.get(i).setWeekToWeek("1-16");
                            }
                        }
                        mainMessages1.remove(j);
                        j -= 1;
                    }
                }
            }
            for (int i = 0; i < mainMessages2.size(); i++) {
                for (int j = i + 1; j < mainMessages2.size(); j++) {
                    if (mainMessages2.get(i).getDayOfWeek().equals(mainMessages2.get(j).getDayOfWeek())) {
                        String[] split = mainMessages2.get(i).getWeekToWeek().split("-");
                        String[] split1 = mainMessages2.get(j).getWeekToWeek().split("-");
                        String classes = split[0] + "-" + split1[1];
                        mainMessages2.get(i).setWeekToWeek(classes);
                        if (mainMessages2.get(i).getIsSingle().equals("单")) {
                            mainMessages2.get(i).setIsSingle("全");
                            if (split1[1].equals("15")) {
                                mainMessages2.get(i).setWeekToWeek("1-16");
                            }
                        }
                        mainMessages2.remove(j);
                        j -= 1;
                    }
                }
            }
            for (int i = 0; i < mainMessages3.size(); i++) {
                for (int j = i + 1; j < mainMessages3.size(); j++) {
                    if (mainMessages3.get(i).getDayOfWeek().equals(mainMessages3.get(j).getDayOfWeek())) {
                        String[] split = mainMessages3.get(i).getWeekToWeek().split("-");
                        String[] split1 = mainMessages3.get(j).getWeekToWeek().split("-");
                        String classes = split[0] + "-" + split1[1];
                        mainMessages3.get(i).setWeekToWeek(classes);
                        if (mainMessages3.get(i).getIsSingle().equals("单")) {
                            mainMessages3.get(i).setIsSingle("全");
                            if (split1[1].equals("15")) {
                                mainMessages3.get(i).setWeekToWeek("1-16");
                            }
                        }
                        mainMessages3.remove(j);
                        j -= 1;
                    }
                }
            }
            for (int i = 0; i < mainMessages4.size(); i++) {
                for (int j = i + 1; j < mainMessages4.size(); j++) {
                    if (mainMessages4.get(i).getDayOfWeek().equals(mainMessages4.get(j).getDayOfWeek())) {
                        String[] split = mainMessages4.get(i).getWeekToWeek().split("-");
                        String[] split1 = mainMessages4.get(j).getWeekToWeek().split("-");
                        String classes = split[0] + "-" + split1[1];
                        mainMessages4.get(i).setWeekToWeek(classes);
                        if (mainMessages4.get(i).getIsSingle().equals("单")) {
                            mainMessages4.get(i).setIsSingle("全");
                            if (split1[1].equals("15")) {
                                mainMessages4.get(i).setWeekToWeek("1-16");
                            }
                        }
                        mainMessages4.remove(j);
                        j -= 1;
                    }
                }
            }
            for (int i = 0; i < mainMessages5.size(); i++) {
                for (int j = i + 1; j < mainMessages5.size(); j++) {
                    if (mainMessages5.get(i).getDayOfWeek().equals(mainMessages5.get(j).getDayOfWeek())) {
                        String[] split = mainMessages5.get(i).getWeekToWeek().split("-");
                        String[] split1 = mainMessages5.get(j).getWeekToWeek().split("-");
                        String classes = split[0] + "-" + split1[1];
                        mainMessages5.get(i).setWeekToWeek(classes);
                        if (mainMessages5.get(i).getIsSingle().equals("单")) {
                            mainMessages5.get(i).setIsSingle("全");
                            if (split1[1].equals("15")) {
                                mainMessages5.get(i).setWeekToWeek("1-16");
                            }
                        }
                        mainMessages5.remove(j);
                        j -= 1;
                    }
                }
            }

            //对课进行补充
            if (mainMessages1.size() != 5) {
                int i1 = 1;
                int i2 = 1;
                int i3 = 1;
                int i4 = 1;
                int i5 = 1;
                for (int i = 0; i < mainMessages1.size(); i++) {
                    if (mainMessages1.get(i).getDayOfWeek().equals("周一")) {
                        i1++;
                    } else if (mainMessages1.get(i).getDayOfWeek().equals("周二")) {
                        i2++;
                    } else if (mainMessages1.get(i).getDayOfWeek().equals("周三")) {
                        i3++;
                    } else if (mainMessages1.get(i).getDayOfWeek().equals("周四")) {
                        i4++;
                    } else if (mainMessages1.get(i).getDayOfWeek().equals("周五")) {
                        i5++;
                    }
                }

                if (i1 < 2) {
                    mainMessages1.add(new MainMessages("全", "0-0", "周一", "1-2"));
                }
                ;
                if (i2 < 2) {
                    mainMessages1.add(new MainMessages("全", "0-0", "周二", "1-2"));
                }
                ;
                if (i3 < 2) {
                    mainMessages1.add(new MainMessages("全", "0-0", "周三", "1-2"));
                }
                ;
                if (i4 < 2) {
                    mainMessages1.add(new MainMessages("全", "0-0", "周四", "1-2"));
                }
                ;
                if (i5 < 2) {
                    mainMessages1.add(new MainMessages("全", "0-0", "周五", "1-2"));
                }
                ;
            }
            if (mainMessages2.size() != 5) {
                int i1 = 1;
                int i2 = 1;
                int i3 = 1;
                int i4 = 1;
                int i5 = 1;
                for (int i = 0; i < mainMessages2.size(); i++) {
                    if (mainMessages2.get(i).getDayOfWeek().equals("周一")) {
                        i1++;
                    } else if (mainMessages2.get(i).getDayOfWeek().equals("周二")) {
                        i2++;
                    } else if (mainMessages2.get(i).getDayOfWeek().equals("周三")) {
                        i3++;
                    } else if (mainMessages2.get(i).getDayOfWeek().equals("周四")) {
                        i4++;
                    } else if (mainMessages2.get(i).getDayOfWeek().equals("周五")) {
                        i5++;
                    }
                }

                if (i1 < 2) {
                    mainMessages2.add(new MainMessages("全", "0-0", "周一", "3-4"));
                }
                ;
                if (i2 < 2) {
                    mainMessages2.add(new MainMessages("全", "0-0", "周二", "3-4"));
                }
                ;
                if (i3 < 2) {
                    mainMessages2.add(new MainMessages("全", "0-0", "周三", "3-4"));
                }
                ;
                if (i4 < 2) {
                    mainMessages2.add(new MainMessages("全", "0-0", "周四", "3-4"));
                }
                ;
                if (i5 < 2) {
                    mainMessages2.add(new MainMessages("全", "0-0", "周五", "3-4"));
                }
                ;
            }
            if (mainMessages3.size() != 5) {
                int i1 = 1;
                int i2 = 1;
                int i3 = 1;
                int i4 = 1;
                int i5 = 1;
                for (int i = 0; i < mainMessages3.size(); i++) {
                    if (mainMessages3.get(i).getDayOfWeek().equals("周一")) {
                        i1++;
                    } else if (mainMessages3.get(i).getDayOfWeek().equals("周二")) {
                        i2++;
                    } else if (mainMessages3.get(i).getDayOfWeek().equals("周三")) {
                        i3++;
                    } else if (mainMessages3.get(i).getDayOfWeek().equals("周四")) {
                        i4++;
                    } else if (mainMessages3.get(i).getDayOfWeek().equals("周五")) {
                        i5++;
                    }
                }

                if (i1 < 2) {
                    mainMessages3.add(new MainMessages("全", "0-0", "周一", "5-6"));
                }
                ;
                if (i2 < 2) {
                    mainMessages3.add(new MainMessages("全", "0-0", "周二", "5-6"));
                }
                ;
                if (i3 < 2) {
                    mainMessages3.add(new MainMessages("全", "0-0", "周三", "5-6"));
                }
                ;
                if (i4 < 2) {
                    mainMessages3.add(new MainMessages("全", "0-0", "周四", "5-6"));
                }
                ;
                if (i5 < 2) {
                    mainMessages3.add(new MainMessages("全", "0-0", "周五", "5-6"));
                }
                ;
            }
            if (mainMessages4.size() != 5) {
                int i1 = 1;
                int i2 = 1;
                int i3 = 1;
                int i4 = 1;
                int i5 = 1;
                for (int i = 0; i < mainMessages4.size(); i++) {
                    if (mainMessages4.get(i).getDayOfWeek().equals("周一")) {
                        i1++;
                    } else if (mainMessages4.get(i).getDayOfWeek().equals("周二")) {
                        i2++;
                    } else if (mainMessages4.get(i).getDayOfWeek().equals("周三")) {
                        i3++;
                    } else if (mainMessages4.get(i).getDayOfWeek().equals("周四")) {
                        i4++;
                    } else if (mainMessages4.get(i).getDayOfWeek().equals("周五")) {
                        i5++;
                    }
                }
                LocalTime start = LocalTime.of(14, 40);
                LocalTime last = LocalTime.of(15, 00);
                LocalTime late = LocalTime.of(15, 20);
                if (i1 < 2) {
                    mainMessages4.add(new MainMessages("全", "0-0", "周一", "7-8"));
                }
                ;
                if (i2 < 2) {
                    mainMessages4.add(new MainMessages("全", "0-0", "周二", "7-8"));
                }
                ;
                if (i3 < 2) {
                    mainMessages4.add(new MainMessages("全", "0-0", "周三", "7-8"));
                }
                ;
                if (i4 < 2) {
                    mainMessages4.add(new MainMessages("全", "0-0", "周四", "7-8"));
                }
                ;
                if (i5 < 2) {
                    mainMessages4.add(new MainMessages("全", "0-0", "周五", "7-8"));
                }
                ;
            }
            if (mainMessages5.size() != 5) {
                int i1 = 1;
                int i2 = 1;
                int i3 = 1;
                int i4 = 1;
                int i5 = 1;
                for (int i = 0; i < mainMessages5.size(); i++) {
                    if (mainMessages5.get(i).getDayOfWeek().equals("周一")) {
                        i1++;
                    } else if (mainMessages5.get(i).getDayOfWeek().equals("周二")) {
                        i2++;
                    } else if (mainMessages5.get(i).getDayOfWeek().equals("周三")) {
                        i3++;
                    } else if (mainMessages5.get(i).getDayOfWeek().equals("周四")) {
                        i4++;
                    } else if (mainMessages5.get(i).getDayOfWeek().equals("周五")) {
                        i5++;
                    }
                }

                if (i1 < 2) {
                    mainMessages5.add(new MainMessages("全", "0-0", "周一", "9-10"));
                }
                ;
                if (i2 < 2) {
                    mainMessages5.add(new MainMessages("全", "0-0", "周二", "9-10"));
                }
                ;
                if (i3 < 2) {
                    mainMessages5.add(new MainMessages("全", "0-0", "周三", "9-10"));
                }
                ;
                if (i4 < 2) {
                    mainMessages5.add(new MainMessages("全", "0-0", "周四", "9-10"));
                }
                ;
                if (i5 < 2) {
                    mainMessages5.add(new MainMessages("全", "0-0", "周五", "9-10"));
                }
                ;
            }

            //添加到大集合中
            for (int i = 0; i < mainMessages1.size(); i++) {
                classList.add(mainMessages1.get(i));
            }
            for (int i = 0; i < mainMessages2.size(); i++) {
                classList.add(mainMessages2.get(i));
            }
            for (int i = 0; i < mainMessages3.size(); i++) {
                classList.add(mainMessages3.get(i));
            }
            for (int i = 0; i < mainMessages4.size(); i++) {
                classList.add(mainMessages4.get(i));
            }
            for (int i = 0; i < mainMessages5.size(); i++) {
                classList.add(mainMessages5.get(i));
            }
        }else {

        }
}

    public List<MainMessages> getClassMessages(String schedule) {

        String pattern1 = "单(\\d+-\\d+),([\\u4E00-\\u9FFF]{2}),(\\d+-\\d+)节.*?";
        String pattern2 = "双(\\d+-\\d+),([\\u4E00-\\u9FFF]{2}),(\\d+-\\d+)节.*?";
        String pattern3 = "(\\d+-\\d+),([\\u4E00-\\u9FFF]{2}),(\\d+-\\d+)节.*?";


        Pattern regexPattern1 = Pattern.compile(pattern1);
        Matcher matcher1 = regexPattern1.matcher(schedule);

        Pattern regexPattern2 = Pattern.compile(pattern2);
        Matcher matcher2 = regexPattern2.matcher(schedule);

        Pattern regexPattern3 = Pattern.compile(pattern3);
        Matcher matcher3 = regexPattern3.matcher(schedule);


        while (matcher1.find()) {
            //单周
            MainMessages mainMessages =  new MainMessages();
            String isSingle = "单";
            String weekToWeek = matcher1.group(1);
            String  dayOfWeek = matcher1.group(2);
            String  classToClass = matcher1.group(3);

            mainMessages.setIsSingle(isSingle);
            mainMessages.setWeekToWeek(weekToWeek);
            mainMessages.setDayOfWeek(dayOfWeek);
            mainMessages.setClassToClass(classToClass);
            list.add(mainMessages);
        }
        while (matcher2.find()) {
            //双周
            MainMessages mainMessages =  new MainMessages();
            String isSingle = "双";
            String weekToWeek = matcher2.group(1);
            String  dayOfWeek = matcher2.group(2);
            String  classToClass = matcher2.group(3);

            mainMessages.setIsSingle(isSingle);
            mainMessages.setWeekToWeek(weekToWeek);
            mainMessages.setDayOfWeek(dayOfWeek);
            mainMessages.setClassToClass(classToClass);
            list.add(mainMessages);
        }

        while (matcher3.find()) {
            //不分单双周
            MainMessages mainMessages = new MainMessages();
            // String isSingle = "双";
            String weekToWeek = matcher3.group(1);
            String  dayOfWeek = matcher3.group(2);
            String  classToClass = matcher3.group(3);

            mainMessages.setIsSingle("全");
            mainMessages.setWeekToWeek(weekToWeek);
            mainMessages.setDayOfWeek(dayOfWeek);
            mainMessages.setClassToClass(classToClass);
            list.add(mainMessages);
        }

        return list;
    }
}
