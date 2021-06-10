import SwiftUI
import shared

struct ContentView: View {
    @Binding var text: String
	var body: some View {
        Text(text)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(text: .constant("test"))
	}
}
