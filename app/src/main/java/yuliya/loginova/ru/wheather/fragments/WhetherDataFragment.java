package yuliya.loginova.ru.wheather.fragments;

import android.app.Fragment;
import android.os.Bundle;

import yuliya.loginova.ru.wheather.SettingsParcel;

public class WhetherDataFragment extends Fragment {

    public static final String PARCEL = "parcel";

    public static WhetherDataFragment create(SettingsParcel parcel) {
        WhetherDataFragment f = new WhetherDataFragment();

        // передача параметра
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        f.setArguments(args);
        return f;
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_coatofarm, container, false);
        // определить какой герб надо показать, и показать его
        ImageView coatOfArms = (ImageView) layout.findViewById(R.id.imageView);
        TextView cityNameView = (TextView) layout.findViewById(R.id.textView);

        // получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        SettingsParcel parcel = getParcel();

        // выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        cityNameView.setText(parcel.getCityName());
        return layout; // Вместо макета используем сразу картинку
    }

    public SettingsParcel getParcel() {
        SettingsParcel parcel = (SettingsParcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }*/
}
