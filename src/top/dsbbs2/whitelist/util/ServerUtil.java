package top.dsbbs2.whitelist.util;

import org.bukkit.Bukkit;
import top.dsbbs2.whitelist.WhiteListPlugin;

public class ServerUtil {
    public static void updateJson(){
        try {
            WhiteListPlugin.instance.whitelist.saveConfig();
            WhiteListPlugin.instance.extraConfig.saveConfig();
            System.out.println("��a[WL]�����ļ���ˢ��!");
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("��c[WL]�����ļ�ˢ��ʧ��!");
            System.out.println("��c[WL]���������ļ�������Ϊ�Ķ�����!");
        }
    }
    public static boolean getOnlineMode(){
        if(Bukkit.getOnlineMode()){
            MsgUtil.makeDebugMsgAndSend("Bukkit.getOnlineMode() is true");
            return true;
        }else{
            MsgUtil.makeDebugMsgAndSend("Bukkit.getOnlineMode() is false");
            return false;
        }
    }
    public static boolean isOnlineStorageMode()
    {
        return (Bukkit.getOnlineMode() || WhiteListPlugin.instance.whitelist.con.forceOnline.equalsIgnoreCase("Online"))&&!WhiteListPlugin.instance.whitelist.con.forceOnline.equalsIgnoreCase("Offline");
    }
}
