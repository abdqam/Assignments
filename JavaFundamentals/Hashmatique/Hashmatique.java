import java.util.HashMap;
import java.util.Set;
public class Hashmatique{
    public static void main(String[] args) {
        HashMap<String,String> trackList= new HashMap<String,String>();
        trackList.put("song1","lyric1");
        trackList.put("song2","lyric2");
        trackList.put("song3","lyric3");
        trackList.put("song4","lyric4");
        System.out.println(trackList.get("song2"));
        Set<String> Lyrics=trackList.keySet();
        for(String Track:Lyrics){
            System.out.println(Track);
            System.out.println(trackList.get(Track));
        }
    }
}