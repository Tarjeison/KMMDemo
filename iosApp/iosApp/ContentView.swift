import SwiftUI
import shared

struct ContentView: View {
    let text: String
	var body: some View {
        Text(text)
	}
    init(displayText: String) {
        text = displayText
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView(displayText: "Test")
	}
}
