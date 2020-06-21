#include <vendor/gl-serggio-26/hardware/LedControl/1.0/ILedControlHW.h>

namespace vendor {
namespace gl-serggio-26 {
namespace LedControl {
namespace V1_0 {
namespace implementation {

using ::android::hardware::Return;

class LedControlHW : public ILedControlHW {

public:
    LedControlHW();

    Return<int> iLedControlHW(leds ledId, bool stateOn) override;

private:
    ~LedControlHW();
}

} // namespace implementation
} // namespace V1_0
} // namespace LedControl
} // namespace gl-serggio-26
} // namespace vendor
