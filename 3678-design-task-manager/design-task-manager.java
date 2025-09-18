class TaskManager {

    private static class Task {
        int userId;
        int taskId;
        long priority;
        Task(int userId, int taskId, long priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private final TreeSet<Task> tasks;
    private final Map<Integer, Task> byId;

    public TaskManager(List<List<Integer>> init) {
        tasks = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) return Long.compare(b.priority, a.priority);
            if (a.taskId != b.taskId) return Integer.compare(b.taskId, a.taskId);
            return Integer.compare(a.userId, b.userId);
        });
        byId = new HashMap<>();
        for (List<Integer> t : init) {
            int userId = t.get(0);
            int taskId = t.get(1);
            long priority = t.get(2);
            Task task = new Task(userId, taskId, priority);
            tasks.add(task);
            byId.put(taskId, task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        tasks.add(task);
        byId.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task t = byId.get(taskId);
        if (t != null) {
            tasks.remove(t);
            t.priority = newPriority;
            tasks.add(t);
        }
    }

    public void rmv(int taskId) {
        Task t = byId.remove(taskId);
        if (t != null) tasks.remove(t);
    }

    public int execTop() {
        if (tasks.isEmpty()) return -1;
        Task top = tasks.pollFirst();
        byId.remove(top.taskId);
        return top.userId;
    }
}
