import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            ContentView(chuckResponse: ChuckNorrisResponse(categories: [], createdAt: "", iconUrl: "", updatedAt: "", url: "", value: "Morsom vits"))
                .onAppear(perform: {
                    ChuckNorrisRepository().getChuckNorrisFunFact { (chuckJokeResposne, error) in
                        print(chuckJokeResposne)
                    }
                })
            
		}
	}
}
