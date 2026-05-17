import QtQuick 2.15
import QtQuick.Controls 2.15
import QtQuick.Layouts 1.15

Rectangle {
    id: mainView
    visible: vm.mainIsVisible

    Rectangle {
        anchors.fill: parent

        ColumnLayout {
            anchors.fill: parent
            anchors.margins: 16

            // Поле ввода
            Rectangle {
                Layout.fillWidth: true
                border.color: "gray"
                border.width: 1
                radius: 4

                RowLayout {
                    anchors.fill: parent
                    anchors.margins: 8

                    TextField {
                        id: taskInput
                        Layout.fillWidth: true
                        placeholderText: "Задача"
                        text: vm.mainTaskTitle
                        onTextChanged: {
                            api.mainSet(F.taskTitle, text)
                        }

                        onAccepted: {
                            api.mainSet(F.didClickSaveText, true)
                        }
                    }
                }
            }
        }
    }
}