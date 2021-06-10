import SwiftUI
import shared

@main
struct iOSApp: App {
    @ObservedObject var joke = Joke()
	var body: some Scene {
        WindowGroup{
            ContentView(text: $joke.text)
                .onAppear(perform: {
                    joke.loadChuckJoke()
                })
            
		}
	}
}

class Joke: ObservableObject {
    @Published var text: String = "Loading.."
    func loadChuckJoke() {
        ChuckNorrisRepository().getChuckNorrisFunFact { (chuckJokeResponse, error) in
            print(chuckJokeResponse)
            guard let chuckJoke = chuckJokeResponse?.value else {
                self.text = "no response"
                return
            }
            self.text = chuckJoke
        }
    }
    
    func loadSomething() {
        
    }
}
