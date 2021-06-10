import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            ContentView(displayText: "Hei")
                .onAppear(perform: {
                    ChuckNorrisRepository().getChuckNorrisFunFact { (chuckJokeResposne, error) in
                        print(chuckJokeResposne)
                    }
                })
            
		}
	}
}
