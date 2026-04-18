cmake_minimum_required(VERSION 3.16)
project(helloworld)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)
find_package(Qt6 REQUIRED COMPONENTS Quick)
qt_standard_project_setup(REQUIRES 6.8)

# Приложение
set(
    SOURCES
    src/App.cpp
    src/ignore.kd.cpp
    src/VM.cpp
    src/main/main.cpp
)
qt_wrap_cpp(
    SOURCES
    src/ignore.kd.h
    src/VM.h
)
qt_add_executable(hwW64 ${SOURCES})
qt_add_qml_module(
    hwW64
    URI helloworld
    QML_FILES
    src/AppView.qml
    src/main/MainView.qml
)

# SDK
add_library(hw SHARED IMPORTED)
set_target_properties(hw PROPERTIES IMPORTED_IMPLIB ${CMAKE_SOURCE_DIR}/../sdk-windows-x64/hw/build/bin/native/releaseShared/libhw.lib)
target_include_directories(
    hwW64
    PRIVATE
    ${CMAKE_SOURCE_DIR}/../sdk-windows-x64/hw/build/bin/native/releaseShared
    src
    src/main
)

# Link
target_link_libraries(hwW64 PRIVATE Qt6::Quick hw)
