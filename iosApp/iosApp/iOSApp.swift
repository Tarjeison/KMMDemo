import SwiftUI
import shared

@main
struct iOSApp: App {
    @ObservedObject var joke = Joke()
    var body: some Scene {
        WindowGroup{
            ContentView(text: $joke.text)
                .onAppear(perform: {
                    joke.loadOfflineChuck()
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
    
    func loadOfflineChuck() {
        ChuckNorrisOfflineRepository().getChuckNorrisFunFact { (joke, error) in
            guard let chuckJoke = joke else {
                self.text = "no response"
                return
            }
            self.text = chuckJoke
        }
    }
}
