cmake_minimum_required(VERSION 3.4.1)

find_library( log-lib
        log )

set(distribution_DIR C:/zj/AndroidProject/FFmpegTest/app/src/main/jni/armeabi-v7a)


add_library( avutil
        SHARED
        IMPORTED )
set_target_properties( avutil
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavutil.so)

add_library( swresample
        SHARED
        IMPORTED )
set_target_properties( swresample
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libswresample.so)

add_library( avcodec
        SHARED
        IMPORTED )
set_target_properties( avcodec
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavcodec.so)

add_library( avfilter
        SHARED
        IMPORTED )
set_target_properties( avfilter
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavfilter.so)

add_library( swscale
        SHARED
        IMPORTED )
set_target_properties( swscale
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libswscale.so)

add_library( avdevice
        SHARED
        IMPORTED)
set_target_properties( avdevice
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavdevice.so )

add_library( avformat
        SHARED
        IMPORTED )
set_target_properties( avformat
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavformat.so)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

add_library(native-lib
        SHARED
        native-lib.cpp)

include_directories(C:/zj/AndroidProject/FFmpegTest/app/src/main/jni/include)

target_link_libraries(native-lib swresample avcodec avfilter swscale avdevice avformat avutil
        ${log-lib})

