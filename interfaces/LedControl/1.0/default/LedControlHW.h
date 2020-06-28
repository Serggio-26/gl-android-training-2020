#ifndef _VENDOR_GLS_HARDWARE_LEDCONTROL_V1_0_LEDCONTROL_H_
#define _VENDOR_GLS_HARDWARE_LEDCONTROL_V1_0_LEDCONTROL_H_

#include <vendor/gls/hardware/LedControl/1.0/ILedControlHW.h>

namespace vendor {
namespace gls {
namespace hardware {
namespace LedControl {
namespace V1_0 {
namespace implementation {

using ::android::hardware::Return;

class LedControlHW : public ILedControlHW {

public:
    LedControlHW();

    Return<result_t> iLedControlHW(leds_t ledId, ledState_t state) override;

private:
    ~LedControlHW();
};

} // namespace implementation
} // namespace V1_0
} // namespace LedControl
} // namespace hardware
} // namespace gls
} // namespace vendor

#endif /* _VENDOR_GLS_HARDWARE_LEDCONTROL_V1_0_LEDCONTROL_H_ */

