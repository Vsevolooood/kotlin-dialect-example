import QtQuick
import QtQuick.Controls

Rectangle {
    id: mainView
    visible: vm.mainIsVisible

    Text {
        anchors.horizontalCenter: mainView.horizontalCenter
        font.bold: true
        font.pointSize: 24
        text: vm.mainGreetingText
        y: 30
    }

    Button {
        anchors.horizontalCenter: mainView.horizontalCenter
        onClicked: api.mainSet(F.didClickChangeText, true)
        text: "Change text"
        y: 100
    }
}
