import org.redisson.api.RScoredSortedSet;
import org.redisson.client.protocol.ScoredEntry;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    // Количество пользваотелей на сайте
    private static final int COUNT = 20;

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();
        RScoredSortedSet<String> sortedSet = redis.getUsers();


        for(int i = 1; i <= COUNT; i++){
            redis.userAdd(i);
            TimeUnit.SECONDS.sleep(1);
        }

        while (true) {
            int i = 0;
            for(ScoredEntry<String> entry: sortedSet.entryRange(0, -1)){
                System.out.println("User" + entry.getValue());
                i++;
                if(i % 10 == 0){
                    redis.changeRegTime(0, new Random().nextInt(COUNT + 1));
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("**************");
        }
    }
}
