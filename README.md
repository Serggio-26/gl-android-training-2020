# gl-android-training-2020

## LED Control project

This project for LED control on [**hikey960**](https://www.96boards.org/product/hikey960/) board is created for study purpose.
It consist of the next parts:
- [Android UI app and service](https://github.com/Serggio-26/gl-android-training-2020/tree/ledcontrol_app) (use binder for communication)
- [HAL daemon](https://github.com/Serggio-26/gl-android-training-2020/tree/ledcontrol_hw) (uses HWBinder for communication with java service)
- [SELinux policy](https://github.com/Serggio-26/gl-android-training-2020/tree/ledcontrol_sepolicy) 

This repository includes only make file to build all parts above. All these parts are in  the separate repositories.
