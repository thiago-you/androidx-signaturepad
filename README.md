[![Release](https://jitpack.io/v/thiago-you/androidx-signaturepad.svg)](https://jitpack.io/#thiago-you/androidx-signaturepad)

Androidx Signature Pad
====================

Androidx Signature Pad is an simplified library from [Warting Android Signature Pad](https://github.com/warting/android-signaturepad) with "view" module only. It includes an smaller library, easier to understand, maintain and build. It also adds a new setter method for bitmaps signatures. For the original and full release, including "jetpack compose" module, checkout the Warting's repository.

Library for drawing smooth signatures. It uses variable width Bézier curve interpolation based on [Smoother Signatures](https://developer.squareup.com/blog/smoother-signatures) post by [Square](https://squareup.com).

![Screenshot](/images/header.png)

## Features

* Setter method for bitmap signatures
* Bézier implementation for a smoother line
* Variable point size based on velocity
* Customizable pen color and size
* Bitmap, SVG and Raw-data support

## Installation

Latest version of the library can be found on Jitpack.io.

### Gradle Build

Open your `build.gradle` and make sure that Maven repository is declared into `repositories` section with `Jitpack.io` source:

```gradle
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Then, include the library as dependency:

```gradle
	dependencies {
	    ...
        implementation 'com.github.thiago-you:androidx-signaturepad:Tag'
    }
```

## Usage

1. Add the `SignaturePad` view to the layout XML.

```xml
<you.thiago.signaturepad.views.SignaturePad
    android:id="@+id/signaturePad"
    android:layout_width="match_parent"
    android:layout_height="@dimen/default_pad_height"
    android:background="@color/pad_background"
    android:minHeight="@dimen/default_pad_height" />
```

2. Configure attributes.

* `penMinWidth` - The minimum width of the stroke (default: 3dp [R.dimen.pen_min_width]).
* `penMaxWidth` - The maximum width of the stroke (default: 6dp [R.dimen.pen_max_width]).
* `penColor` - The color of the stroke (default: #012371 [R.color.pen_color_primary]).
* `velocityFilterWeight` - Weight used to modify new velocity based on the previous velocity (default: 0.9 [R.dimen.pen_velocity]).
* `clearOnDoubleClick` - Double click to clear pad (default: false [R.bool.signature_pad_clear_on_double_click])

All default values can be overwritten by XML (colors.xml, values.xml, dimens.xml).

3. Get signature data

* `getSignatureBitmap()` - A signature bitmap with a white background.
* `getTransparentSignatureBitmap()` - A signature bitmap with a transparent background.
* `getSignatureSvg()` - A signature Scalable Vector Graphics document.

4. Set signature image (bitmap)

* `setSignatureBitmap(signature: Bitmap)` - Set bitmap signature on pad.
