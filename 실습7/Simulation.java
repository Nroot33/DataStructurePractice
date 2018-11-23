
public class Simulation {

	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static SimServer[] servers;
	static Client[] clients;
	static Queue queue = new SLinkedQueue();
	static java.util.Random randomArrival;
	static java.util.Random randomService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(args);

		// 리스팅 6.3 참고
		run(); // 구현 해야 할 것.
	}

	static void init(String[] args) {
		if (args.length < 4) {
			System.out.println(
					"Usage : java Simulation <numServers> " + "<numClients> <meanServiceTime> <meanInterarrivalTime> ");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0);
		}

		numServers = Integer.parseInt(args[0]);
		numClients = Integer.parseInt(args[1]);
		meanServiceTime = Integer.parseInt(args[2]);
		meanInterarrivalTime = Integer.parseInt(args[3]);

		servers = new SimServer[numServers];
		clients = new Client[numClients];
		randomService = new ExponentialRandom(meanServiceTime);
		randomArrival = new ExponentialRandom(meanInterarrivalTime);
		queue = new SLinkedQueue();

		for (int j = 0; j < numServers; j++) {
			servers[j] = new SimServer(j, randomService.nextInt());
		}

		System.out.println("	Number of servers = " + numServers);
		System.out.println("	Number of clients = " + numClients);
		System.out.println("	Mean service time = " + meanServiceTime);
		System.out.println("	Mean interarrival time = " + meanInterarrivalTime);

		for (int j = 0; j < numServers; j++) {
			System.out.println("Mean service time for " + servers[j] + "=" + servers[j].getMeanServiceTime());
		}
	}

	static void run() {

		int sum = 0, multisum = 0;

		int i = 0, t = 0;
		int arrivaltime = 0;
		int check = 0;

		// 리스닝 [6.4]
		for (t = 0; check != numClients; t++) {
			if (t == arrivaltime) {
				Client client = clients[i++] = new SimClient(i, t);
				queue.add(client);
				if (i < numClients)
					arrivaltime = t + randomArrival.nextInt();	}
			for (int j = 0; j < numServers; j++) {
				Server server = servers[j];
				if (t == server.getStopTime()) {
					server.stopServing(t);
					++check;			}
				if (server.isIdle() && !queue.empty()) {
					Client client = (SimClient) queue.remove();
					server.startServing(client, t);
				}
			}
		}

		for (int n = 0; n < numClients; n++)
			sum += ((SimClient) clients[n]).getStoptime() - ((SimClient) clients[n]).arrivalTime;

		for (int j = 0; j < numServers; j++) {
			servers[j] = new SimServer(j, randomService.nextInt());  // 서버 초기화
		}

		i = 0;
		t = 0;
		arrivaltime = 0;
		check = 0;

		// 실습 과제
		int index = -1; 
		for (t = 0; check < numClients; t++) {
			if (t == arrivaltime) {
				Client client = clients[i++] = new SimClient(i, t);
				Queue q = servers[++index % numServers].queue();  
				q.add(client);
				if (i < numClients)
					arrivaltime = t + randomArrival.nextInt();
			}

			for (int j = 0; j < numServers; j++) { 
				Server server = servers[j]; 
				Queue q = servers[j].queue(); 
				if (t == server.getStopTime()) { 
					server.stopServing(t); 
					++check; 
				}
				if (server.isIdle() && !q.empty()) { 
					Client client = (SimClient) q.remove(); 
					server.startServing(client, t); 
				}
			}
		}

		for (int n = 0; n < numClients; n++)
			multisum += ((SimClient) clients[n]).getStoptime() - ((SimClient) clients[n]).arrivalTime;

		System.out.println("Single Queue : " + sum / numClients + ", Multi Queue : " + multisum / numClients);
	}
}