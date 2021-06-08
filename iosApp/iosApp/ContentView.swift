import SwiftUI
import shared

struct ContentView: View {
    let joke: String
	var body: some View {
        Text(joke)
	}
    init(chuckResponse: ChuckNorrisResponse) {
        joke = chuckResponse.value
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView(chuckResponse: ChuckNorrisResponse(categories: [], createdAt: "", iconUrl: "", updatedAt: "", url: "", value: "Morsom vits"))
	}
}
