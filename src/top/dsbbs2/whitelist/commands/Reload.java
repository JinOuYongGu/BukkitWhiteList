package top.dsbbs2.whitelist.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import top.dsbbs2.common.file.FileUtils;
import top.dsbbs2.whitelist.WhiteListPlugin;
import top.dsbbs2.whitelist.util.PlayerUtil;
import top.dsbbs2.whitelist.util.PluginUtil;
import top.dsbbs2.whitelist.util.ServerUtil;
import top.dsbbs2.whitelist.util.VectorUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

public class Reload implements IChildCommand {
    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        try {
            WhiteListPlugin.instance.whitelist.loadConfig();


            PluginUtil.checkConfigFileAndRecover();



            PlayerUtil.informMess = WhiteListPlugin.instance.whitelist.con.mess;
            WhiteListPlugin.compareOnlineMode();
            ServerUtil.updateJson();
            WhiteListPlugin.updateOnlineModeinWhiteListJson();
            arg0.sendMessage("[WL]�����ļ����سɹ�");
            if(ServerUtil.isOnlineStorageMode()) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    PlayerUtil.checkUUIDAndName(player);
                }
                System.out.println("��a[WL]�Ѽ��ȫ����ҵ�UUID��Name!");
            }

        }catch(Throwable e){
            e.printStackTrace();
            System.out.println("��c����whitelist.json�ļ�����!");
            System.out.println("��c�볢���˹��޸ĵ���������!");
            System.out.println("��c����޷��޸Ļ���������,�����������������������,Ȼ��ɾ��whitelist.json��reload ���������ճ�����µ�whitelist.json��ȥ,Ȼ��/wl reload");
        }
        return true;
    }

    @NotNull
    @Override
    public String getUsage() {
        return "/wl reload";
    }

    @NotNull
    @Override
    public Vector<Class<?>> getArgumentsTypes()
    {
        return VectorUtil.toVector();
    }

    @NotNull
    @Override
    public Vector<String> getArgumentsDescriptions()
    {
        return VectorUtil.toVector();
    }

    @NotNull
    @Override
    public String getPermission()
    {
        return "whitelist.reload";
    }
    @NotNull
    @Override
    public String getDescription(){
        return "����BukkitWhitelist�����ļ�";
    }
}
