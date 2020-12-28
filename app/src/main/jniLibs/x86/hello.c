#include <android/log.h>
#define LOG_TAG "BT"
#define PRINT(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)

void dump() {
  PRINT("hello1234567890\n");
}

int add() {

  return 100;
}

/*
int main() {
  dump();

  return 0;
}
*/
