package port.port;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Port extends JavaPlugin {




        public final Logger logger = Logger.getLogger("Minecraft");


        public void onEnable(){

            PluginDescriptionFile pdfFile = this.getDescription();

            this.logger.info(pdfFile.getName() + " 가 실행되었습니다  Version : " + pdfFile.getVersion());

        }


        public void onDisable(){

            PluginDescriptionFile pdfFile = this.getDescription();

            this.logger.info(pdfFile.getName() + "플러그인이 종료되었습니다");


        }



        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

            if(commandLabel.equalsIgnoreCase("Fireworks")){

                shootfireworks();

            }

            return false;

        }


        private void shootfireworks(){

            for (Player player : Bukkit.getOnlinePlayers()){

                Firework firework = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);

                FireworkMeta fireworkm = firework.getFireworkMeta();


                FireworkEffect effect = FireworkEffect.builder().flicker(true).withColor(Color.AQUA)

                        .withFade(Color.BLACK).with(Type.BALL).trail(false).build();

                FireworkEffect effect2 = FireworkEffect.builder().flicker(false).withColor(Color.RED)

                        .withFade(Color.LIME).with(Type.BURST).trail(true).build();

                //flicker = 반짝이는여부, color = 폭죽색깔, fade = 2번째색깔, type = 모양, trail = 잔상

                Random random = new Random();//둘중하나 랜덤으로 쏨

                int rf = random.nextInt(2) + 1;


                if(rf == 1){

                    fireworkm.addEffect(effect);

                }

                else if(rf == 2){



                    fireworkm.addEffect(effect2);

                }


                fireworkm.setPower(1);//폭죽이 올라가는 옾이 1~3

                firework.setFireworkMeta(fireworkm);

            }

        }

    }