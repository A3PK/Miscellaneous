/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package IOI_Algorithm_prep;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;

public class Greedy {
    private class Activity implements Comparable<Activity> {
        private int start;
        private int finish;

        public Activity(int s, int f) {
            start = s;
            finish = f;
        }

        public int compareTo(Activity other) {
            if (this.getFinish() < other.getFinish()) {
                return -1;
            }
            else if (this.getFinish() > other.getFinish()) {
                return 1;
            }
            else {
                return Integer.compare(this.getStart(), other.getStart());
            }
        }

        public String toString() {
            return "Activity{" +
                    "start=" + getStart() +
                    ", finish=" + getFinish() +
                    '}';
        }

        public int getFinish() {
            return finish;
        }

        public int getStart() {
            return start;
        }

    }

    public static Activity[] returnDoableActivities(Activity[] acts) {
        ArrayList<Activity> doables = new ArrayList<>();
        int largestFinish = 0;
        for (Activity act : acts) {
            if (act.getStart() > largestFinish) {
                doables.add(act);
                largestFinish = act.getFinish();
            }
        }
        return doables.toArray(new Activity[0]);
    }
    
    public static void main(String[] args) {
        Activity[] activities = new Activity[10];
        for (int i = 0; i < 10; i++) {
            int finish = StdRandom.uniform(2, 10);
            int start = StdRandom.uniform(1, finish);
            activities[i] = new Greedy().new Activity(start, finish);
        }
        Arrays.sort(activities);
        System.out.println(Arrays.toString(activities));
        System.out.println(Arrays.toString(returnDoableActivities(activities)));
    }
}
