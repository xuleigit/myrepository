/*
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.jsict.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class StringUtil {

    public static boolean strIsNullOrEmpty(String s) {
        return (null == s || s.trim().length() < 1);
    }


    public static String readData(HttpServletRequest request) {
        BufferedReader br = null;

        try {
            StringBuilder result = new StringBuilder();

            String line;
            for(br = request.getReader(); (line = br.readLine()) != null; result.append(line)) {
                if(result.length() > 0) {
                    result.append("\n");
                }
            }

            line = result.toString();
            return line;
        } catch (IOException var12) {
            throw new RuntimeException(var12);
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException var11) {
                    log.error(var11.getMessage(), var11);
                }
            }

        }
    }

    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if(firstChar >= 65 && firstChar <= 90) {
            char[] arr = str.toCharArray();
            arr[0] = (char)(arr[0] + 32);
            return new String(arr);
        } else {
            return str;
        }
    }

    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if(firstChar >= 97 && firstChar <= 122) {
            char[] arr = str.toCharArray();
            arr[0] = (char)(arr[0] - 32);
            return new String(arr);
        } else {
            return str;
        }
    }

    public static boolean isBlank(String str) {
        if(str == null) {
            return true;
        } else {
            int len = str.length();
            if(len == 0) {
                return true;
            } else {
                int i = 0;

                while(i < len) {
                    switch(str.charAt(i)) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                            ++i;
                            break;
                        default:
                            return false;
                    }
                }

                return true;
            }
        }
    }

    public static boolean notBlank(String str) {
        return !isBlank(str);
    }

    public static boolean notBlank(String... strings) {
        if(strings == null) {
            return false;
        } else {
            String[] arr$ = strings;
            int len$ = strings.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                if(isBlank(str)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean notNull(Object... paras) {
        if(paras == null) {
            return false;
        } else {
            Object[] arr$ = paras;
            int len$ = paras.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Object obj = arr$[i$];
                if(obj == null) {
                    return false;
                }
            }

            return true;
        }
    }

    public static String toCamelCase(String stringWithUnderline) {
        if(stringWithUnderline.indexOf(95) == -1) {
            return stringWithUnderline;
        } else {
            stringWithUnderline = stringWithUnderline.toLowerCase();
            char[] fromArray = stringWithUnderline.toCharArray();
            char[] toArray = new char[fromArray.length];
            int j = 0;

            for(int i = 0; i < fromArray.length; ++i) {
                if(fromArray[i] == 95) {
                    ++i;
                    if(i < fromArray.length) {
                        toArray[j++] = Character.toUpperCase(fromArray[i]);
                    }
                } else {
                    toArray[j++] = fromArray[i];
                }
            }

            return new String(toArray, 0, j);
        }
    }

    public static String join(String[] stringArray) {
        StringBuilder sb = new StringBuilder();
        String[] arr$ = stringArray;
        int len$ = stringArray.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String s = arr$[i$];
            sb.append(s);
        }

        return sb.toString();
    }

    public static String join(String[] stringArray, String separator) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < stringArray.length; ++i) {
            if(i > 0) {
                sb.append(separator);
            }

            sb.append(stringArray[i]);
        }

        return sb.toString();
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
